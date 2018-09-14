package com.income.icminwentaryzacja.fragments.abstraction

import android.Manifest
import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.asynctasks.AsyncTaskWithProgress
import com.income.icminwentaryzacja.backstack.BackstackService
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.backstack.ROUTE_ARGUMENTS_KEY
import com.income.icminwentaryzacja.database.DBContext
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.ModeCSV
import com.income.icminwentaryzacja.fragments.information.InfoFragmentRoute
import com.income.icminwentaryzacja.fragments.location.ChooseLocationRoute
import com.income.icminwentaryzacja.fragments.login.LoginFragment
import com.income.icminwentaryzacja.fragments.login.LoginRoute
import com.income.icminwentaryzacja.fragments.login.READ_REQUEST_CODE
import com.income.icminwentaryzacja.fragments.positions_list.empty_list.EmptyListRoute
import com.income.icminwentaryzacja.fragments.positions_list.scanned_list.ScannedListRoute
import com.income.icminwentaryzacja.fragments.scan_positions.InfoDialogFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsRoute
import com.income.icminwentaryzacja.handling_file.ReadFileController
import com.income.icminwentaryzacja.handling_file.SaveFileController
import com.income.icminwentaryzacja.utilities.todayDate
import com.raizlabs.android.dbflow.sql.language.Delete
import dagger.android.AndroidInjection
import javax.inject.Inject

const val REQUEST_WRITE_EXTERNAL_STORAGE = 99

abstract class FragmentBase : Fragment() {

    @Inject
    lateinit var dbContext: DBContext

    private var saveController: SaveFileController? = null
    private var readController: ReadFileController? = null

    private var onResumeListeners = mutableSetOf<((FragmentBase) -> Unit)>()
    var modeOfSavingCSV: ModeCSV = ModeCSV.ExportOrOpenNew



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        saveController = SaveFileController(this, dbContext)
        readController = ReadFileController(this)
    }

    fun navigateBack() = BackstackService.get(activity).goBack()


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
                menu.findItem(R.id.generateEmptyCSV).isVisible = true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> {
                modeOfSavingCSV = ModeCSV.ExportAndExitApp
                requestPermissionAndHandleCSV()
            }
            R.id.generateEmptyCSV -> {
                modeOfSavingCSV = ModeCSV.GenerateEmptyCSV
                requestPermissionAndHandleCSV()
            }
            R.id.exportToCSV -> {
                modeOfSavingCSV = ModeCSV.ExportCSV
                requestPermissionAndHandleCSV()
            }
            R.id.changeLocation -> navigateTo(ChooseLocationRoute())
            R.id.listEmpty -> navigateTo(EmptyListRoute((activity as MainActivity).currentLocation))
            R.id.listDesc -> navigateTo(ScannedListRoute((activity as MainActivity).currentLocation))
            R.id.moveToScan -> navigateTo(ScanPositionsRoute((activity as MainActivity).currentLocation))
            R.id.logout -> navigateTo(LoginRoute())
            R.id.info -> navigateTo(InfoFragmentRoute())
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
                                readController?.readFileContent(it)
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

    private fun showIfSavedAndClosActivity() {
        toast(getString(R.string.saved))
        activity.finish()
    }

    private fun showIfSavedAndNavigate() {
        toast(getString(R.string.saved))
        Delete.table(Item::class.java)
        dbContext.deleteOldLocations()
        navigateTo(ChooseLocationRoute())
    }

    private fun showIfSavedAndSelectFile() {
        toast(getString(R.string.saved))
        Delete.table(Item::class.java)
        dbContext.deleteOldLocations()
        selectCSVFile()
    }

    fun requestPermissionAndHandleCSV() {
        val permission = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        } else {
            when (modeOfSavingCSV) {
                ModeCSV.ExportCSV -> exportCsv()
                ModeCSV.ExportAndOpenNew -> exportAndOpenNew()
                ModeCSV.ExportOrOpenNew -> exportOrOpenNew()
                ModeCSV.ExportAndExitApp -> exportAndExitApp()
                ModeCSV.ExportAndStartEpmtyInventory -> exportStartNewEmptyInventory()
                ModeCSV.GenerateEmptyCSV -> generateEmptyCSV()
            }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(activity,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_WRITE_EXTERNAL_STORAGE)
    }

    private fun exportCsv() {
        if ((activity as MainActivity).isDemoVersion)
            InfoDialogFragment({ }, getString(R.string.version_demo_not_save_file), isWebLink = true).show((activity as MainActivity).fragmentManager, "dialog")
        else
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems() }, { toast(getString(R.string.saved)) }).execute() }, "Export_" + todayDate.replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportAndOpenNew() {
        if ((activity as MainActivity).isDemoVersion)
            InfoDialogFragment({ selectCSVFile() }, getString(R.string.version_demo_not_save_file), isWebLink = true).show((activity as MainActivity).fragmentManager, "dialog")
        else
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems() }, { showIfSavedAndSelectFile() }).execute() }, "Export_" + todayDate.replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportStartNewEmptyInventory() {
        if ((activity as MainActivity).isDemoVersion)
            InfoDialogFragment({ selectCSVFile() }, getString(R.string.version_demo_not_save_file), isWebLink = true).show((activity as MainActivity).fragmentManager, "dialog")
        else
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems() }, { showIfSavedAndNavigate() }).execute() }, "Export_" + todayDate.replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportOrOpenNew() {
        if ((activity as MainActivity).isDemoVersion)
            InfoDialogFragment({ selectCSVFile() }, getString(R.string.version_demo_not_save_file), isWebLink = true).show((activity as MainActivity).fragmentManager, "dialog")
        else
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems() }, { toast(getString(R.string.saved)) }).execute() }, "Export_" + todayDate.replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun generateEmptyCSV() {
        InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems(isEmptyFile = true) }, { toast(getString(R.string.saved)) }).execute() }, "Export_empty_" + todayDate.replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportAndExitApp() {
        if (dbContext.isEmpty || (activity as MainActivity).isDemoVersion) {
            activity.finish()
            return
        }
        InfoDialogFragment({ AsyncTaskWithProgress(activity as MainActivity, { saveController?.saveItems() }, { showIfSavedAndClosActivity() }).execute() }, "Export_" + todayDate.replace(":", "_") + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }
}