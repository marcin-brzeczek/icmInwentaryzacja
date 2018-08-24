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
import android.os.Parcelable
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.backstack.BackstackService
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.backstack.ROUTE_ARGUMENTS_KEY
import com.income.icminwentaryzacja.cache.LocationCache
import com.income.icminwentaryzacja.database.AppDatabase
import com.income.icminwentaryzacja.database.DBContext
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.choose_location.ChooseLocationFragment
import com.income.icminwentaryzacja.fragments.choose_location.ChooseLocationRoute
import com.income.icminwentaryzacja.fragments.login.READ_REQUEST_CODE
import com.income.icminwentaryzacja.fragments.new_position.NewItemRoute
import com.income.icminwentaryzacja.fragments.positions_list.empty_list.EmptyListFragment
import com.income.icminwentaryzacja.fragments.positions_list.empty_list.EmptyListRoute
import com.income.icminwentaryzacja.fragments.positions_list.scanned_list.ScannedListFragment
import com.income.icminwentaryzacja.fragments.positions_list.scanned_list.ScannedListRoute
import com.income.icminwentaryzacja.fragments.scan_positions.InfoDialogFragment
import com.income.icminwentaryzacja.fragments.scan_positions.NewPositionDialogFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ProgressDialogFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsFragment
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.sql.language.Delete
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
    var saveCurrentInventory = false

    private val items = mutableListOf<Item>()


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
            is ScanPositionsFragment -> {
                menu.findItem(R.id.exportToCSV).isVisible = true
                menu.findItem(R.id.listEmpty).isVisible = true
                menu.findItem(R.id.listDesc).isVisible = true
                menu.findItem(R.id.exit).isVisible = false
                menu.findItem(R.id.changeLocation).isVisible = true
            }
            is ChooseLocationFragment -> menu.findItem(R.id.exit).isVisible = false
            is ScannedListFragment -> menu.findItem(R.id.changeLocation).isVisible = true
            is EmptyListFragment -> menu.findItem(R.id.changeLocation).isVisible = true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> activity.finish()
            R.id.exportToCSV -> requestPermissionOrSaveCSV()
            R.id.changeLocation -> navigateTo(ChooseLocationRoute())
            R.id.listEmpty -> navigateTo(EmptyListRoute(LocationCache.locationName))
            R.id.listDesc -> navigateTo(ScannedListRoute(LocationCache.locationName))
        }
        return super.onOptionsItemSelected(item)
    }

    /********** Wybranie i  czytanie z pliku csv z telefonu */
    fun selectCSVFile() {
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
            items.add(item)
            currentline = reader.readLine()
        }
        inputStream.close()
        println(stringBuilder.toString())
        storage()
        return stringBuilder.toString()
    }

    fun storage() {

        FlowManager.getDatabase(AppDatabase::class.java)
                .beginTransactionAsync(ProcessModelTransaction.Builder<Item>(
                        ProcessModelTransaction.ProcessModel<Item> { model, wrapper -> model?.save() }).addAll(items).build())  // add elements (can also handle multiple)
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

    /* Internal storage */
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
            selectCSVFile()
        }
    }

    fun requestPermissionOrSaveCSV() {
        val permission = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        } else {
            if (saveCurrentInventory)
                InfoDialogFragment({ saveAsyncCSVAndOpenNew().execute() }, "Export_" + getTodaysDate().replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
            else
                InfoDialogFragment({ saveAsyncCSV().execute() }, "Export_" + getTodaysDate().replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")

        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(activity,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_WRITE_EXTERNAL_STORAGE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_WRITE_EXTERNAL_STORAGE -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (saveCurrentInventory)
                        InfoDialogFragment({ saveAsyncCSVAndOpenNew().execute() }, "Export_" + getTodaysDate().replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
                    else
                        InfoDialogFragment({ saveAsyncCSV().execute() }, "Export_" + getTodaysDate().replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")

                } else {
                    Toast.makeText(activity, "Musisz zezwolić na dostęp do pamięci telefonu aby zapisać plik", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}