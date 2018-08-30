package com.income.icminwentaryzacja.fragments.abstraction

import android.Manifest
import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.backstack.BackstackService
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.backstack.ROUTE_ARGUMENTS_KEY
import com.income.icminwentaryzacja.cache.LocationCache
import com.income.icminwentaryzacja.database.AppDatabase
import com.income.icminwentaryzacja.database.DBContext
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.database.dto.Item_Table
import com.income.icminwentaryzacja.database.dto.Location
import com.income.icminwentaryzacja.database.dto.Location_Table
import com.income.icminwentaryzacja.fragments.ModeCSV
import com.income.icminwentaryzacja.fragments.location.ChooseLocationFragment
import com.income.icminwentaryzacja.fragments.location.ChooseLocationRoute
import com.income.icminwentaryzacja.fragments.login.LoginFragment
import com.income.icminwentaryzacja.fragments.login.LoginRoute
import com.income.icminwentaryzacja.fragments.login.READ_REQUEST_CODE
import com.income.icminwentaryzacja.fragments.positions_list.empty_list.EmptyListFragment
import com.income.icminwentaryzacja.fragments.positions_list.empty_list.EmptyListRoute
import com.income.icminwentaryzacja.fragments.positions_list.scanned_list.ScannedListFragment
import com.income.icminwentaryzacja.fragments.positions_list.scanned_list.ScannedListRoute
import com.income.icminwentaryzacja.fragments.scan_positions.InfoDialogFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ProgressDialogFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsRoute
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.sql.language.Delete
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction
import dagger.android.AndroidInjection
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

const val REQUEST_WRITE_EXTERNAL_STORAGE = 99

abstract class FragmentBase : Fragment(), IOnResumeNotifier {

    @Inject
    lateinit var dbContext: DBContext

    private var onResumeListeners = mutableSetOf<((FragmentBase) -> Unit)>()
    var modeOfSavingCSV: ModeCSV = ModeCSV.ExportOrOpenNew

    private val items = mutableListOf<Item>()

    /*TODO lepiej lokalizacje wybraną trzymać właściowości globalnej niż w singletonie*/
    var currentLocation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        onResumeListeners.forEach { it.invoke(this) }
    }

    override fun addOnResumeListener(action: FragmentBase.() -> Unit) {
        onResumeListeners.add(action)
    }

    override fun removeOnResumeListener(action: FragmentBase.() -> Unit) {
        onResumeListeners.remove(action)
    }

    fun navigateBack() {
        BackstackService.get(activity).goBack()
    }

    fun navigateTo(route: BaseRoute, isReturnigResult: Boolean = false) {
        BackstackService.get(activity).goTo(route.apply {
            isReturning = isReturnigResult
            if (isReturning)
                returnRoute = arguments.getParcelable(ROUTE_ARGUMENTS_KEY)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.main, menu)
        when (this) {
            is LoginFragment -> {
                menu.findItem(R.id.logout).isVisible = false
                menu.findItem(R.id.changeLocation).isVisible = false
                menu.findItem(R.id.moveToScan).isVisible = false
                menu.findItem(R.id.listEmpty).isVisible = false
                menu.findItem(R.id.listDesc).isVisible = false
            }
            is ScanPositionsFragment -> menu.findItem(R.id.moveToScan).isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> {
                modeOfSavingCSV = ModeCSV.ExportAndExitApp
                requestPermissionAndHandleCSV()
            }
            R.id.exportToCSV -> requestPermissionAndHandleCSV()
            R.id.changeLocation -> navigateTo(ChooseLocationRoute())
            R.id.listEmpty -> navigateTo(EmptyListRoute(LocationCache.locationName))
            R.id.listDesc -> navigateTo(ScannedListRoute(LocationCache.locationName))
            R.id.moveToScan -> navigateTo(ScanPositionsRoute(LocationCache.locationName))
            R.id.logout -> navigateTo(LoginRoute())
        }
        return super.onOptionsItemSelected(item)
    }

    /********** Wybranie i  czytanie z pliku csv z telefonu */
    fun selectCSVFile() {
        dbContext.deleteOldLocations()
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        startActivityForResult(Intent.createChooser(intent, "Open CSV"), READ_REQUEST_CODE)
    }

    private fun readFileContent(uri: Uri?): String {

        val inputStream = activity.contentResolver.openInputStream(uri)
        val reader = LineNumberReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        reader.readLine() // read first line - the headers of columns

        var currentline = reader.readLine()
        while (currentline != null && reader.lineNumber > 1) {
            val arrayLine = currentline.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val item = Item()
            item.code = arrayLine[1]
            item.supportCode = arrayLine[2]
            item.shortName = arrayLine[3]
            item.name = arrayLine[4]
            item.oldLocation = arrayLine[5]
            item.startNumber = arrayLine[6].toDouble()
            item.itemState = ""
            items.add(item)
            currentline = reader.readLine()
        }
        inputStream.close()
        println(stringBuilder.toString())
        storageItems()
        return stringBuilder.toString()
    }

    fun storageItems() {
        FlowManager.getDatabase(AppDatabase::class.java)
            .beginTransactionAsync(ProcessModelTransaction.Builder<Item>(
                ProcessModelTransaction.ProcessModel<Item> { model, wrapper -> model?.save() }).addAll(items).build())  // add elements (can also handle multiple)
            .error { transaction, error -> }
            .success {
                //                    navigateTo(ChooseLocationRoute())
                storageLocations()
            }.build().execute()
    }

    fun storageLocations() {
        FlowManager.getDatabase(AppDatabase::class.java)
            .beginTransactionAsync(ProcessModelTransaction.Builder<Location>(
                ProcessModelTransaction.ProcessModel<Location> { model, wrapper -> model?.save() }).addAll(items.distinctBy { it.oldLocation }.map { Location(name = it.oldLocation) }).build())  // add elements (can also handle multiple)
            .error { transaction, error -> }
            .success {
                navigateTo(ChooseLocationRoute())

            }.build().execute()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            READ_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    data?.data?.let {
                        if (!it.path.contains(".csv")) {
                            toast(getString(R.string.incorrect_file_format))
                            return
                        } else {
                            try {
                                readFileContent(it)
                            } catch (e: Exception) {
                                toast(getString(R.string.incorrect_file))
                                e.printStackTrace()
                            }
                        }
                    }
                }
            }
        }
    }

    /***********Zapis pliku CSV do telefonu*/
    fun saveDocPosToFile() {
        saveDocPosToFile(preparePosToSave())
    }

    private fun preparePosToSave(): String {
        val sb = StringBuilder()

        sb.append(activity.baseContext.getResources().getString(R.string.header_of_exported_file) + "\n")

        /* zapis wszystkich pozycji do pliku (nawet nie skanowanych) */
        val iterator = dbContext.items.queryList().iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()

            sb.append(item.id.toString() + ";") /*id*/
            sb.append(item.code + ";")
            sb.append(item.supportCode + ";")
            sb.append(item.shortName + ";")
            sb.append(item.name + ";")
            sb.append(item.oldLocation + ";")
            sb.append(item.startNumber.toString() + ";")
            sb.append(item.endNumber.toString() + ";")
            sb.append(item.itemState + ";")
            sb.append(dbContext.users.queryList().last().name + ";")
            sb.append("\n")
        }
        return sb.toString()
    }

    /* Internal storageItems */
    private fun saveDocPosToFile(content: String) {
        val date = getTodaysDate()
        val path = Environment.getExternalStorageDirectory().toString()
        val folder = File(path)
        if (!folder.exists()) {
            try {
                folder.mkdir()
            } catch (e: Exception) {
                toast(e.toString())
            }
        }

        val file = File(path + "/Export_" + date.replace(":", "_") + ".csv")
        val out: FileOutputStream
        val myOutWriter: OutputStreamWriter
        try {
            out = FileOutputStream(file)
            myOutWriter = OutputStreamWriter(out)
            myOutWriter.append(content)
            myOutWriter.close()
            out.close()
        } catch (e: Exception) {
            toast(e.toString())
        }
    }

    fun getTodaysDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm")
        val date = Date()
        return dateFormat.format(date)
    }


    inner class saveAsyncCSV() : AsyncTask<Void, Void, Boolean>() {
        val progressDialogFragment = ProgressDialogFragment()
        val ft = (activity as MainActivity).fragmentManager

        override fun onPreExecute() {
            progressDialogFragment.show(ft, "dialog")
        }

        override fun doInBackground(vararg params: Void?): Boolean {
            saveDocPosToFile()
            return true
        }

        override fun onPostExecute(result: Boolean?) {
            progressDialogFragment.dismiss()
            toast(getString(R.string.saved))
        }
    }

    inner class saveAsyncCSVAndOpenNew() : AsyncTask<Void, Void, Boolean>() {
        val progressDialogFragment = ProgressDialogFragment()
        val ft = (activity as MainActivity).fragmentManager

        override fun onPreExecute() {
            progressDialogFragment.show(ft, "dialog")
        }

        override fun doInBackground(vararg params: Void?): Boolean {
            saveDocPosToFile()
            return true
        }

        override fun onPostExecute(result: Boolean?) {
            progressDialogFragment.dismiss()
            toast(getString(R.string.saved))
            Delete.table(Item::class.java)
            dbContext.deleteOldLocations()
            selectCSVFile()
        }
    }

    inner class saveAsyncCSVAndExitApp() : AsyncTask<Void, Void, Boolean>() {
        val progressDialogFragment = ProgressDialogFragment()
        val ft = (activity as MainActivity).fragmentManager

        override fun onPreExecute() {
            progressDialogFragment.show(ft, "dialog")
        }

        override fun doInBackground(vararg params: Void?): Boolean {
            saveDocPosToFile()
            return true
        }

        override fun onPostExecute(result: Boolean?) {
            progressDialogFragment.dismiss()
            toast(getString(R.string.saved))
            activity.finish()
        }
    }

    fun requestPermissionAndHandleCSV() {
        val permission = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        } else {
            when (modeOfSavingCSV) {
                ModeCSV.ExportAndOpenNew -> exportAndOpenNew()
                ModeCSV.ExportOrOpenNew -> exportOrOpenNew()
                ModeCSV.ExportAndExitApp -> exportAndExitApp()
            }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            REQUEST_WRITE_EXTERNAL_STORAGE)
    }

    private fun exportAndOpenNew() {

        InfoDialogFragment({ saveAsyncCSVAndOpenNew().execute() }, "Export_" + getTodaysDate().replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportOrOpenNew() {
        InfoDialogFragment({ saveAsyncCSV().execute() }, "Export_" + getTodaysDate().replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportAndExitApp() {
        if (dbContext.isEmpty) {
            activity.finish()
            return
        }
        InfoDialogFragment({ saveAsyncCSVAndExitApp().execute() }, "Export_" + getTodaysDate().replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }
}