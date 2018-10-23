package com.income.icminventory.fragments.abstraction

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
import com.income.icminventory.R
import com.income.icminventory.activities.MainActivity
import com.income.icminventory.asynctasks.AsyncTaskWithProgress
import com.income.icminventory.backstack.BackstackService
import com.income.icminventory.backstack.BaseRoute
import com.income.icminventory.backstack.ROUTE_ARGUMENTS_KEY
import com.income.icminventory.database.DBContext
import com.income.icminventory.database.dto.Item
import com.income.icminventory.fragments.ModeCSV
import com.income.icminventory.fragments.information.InfoFragment
import com.income.icminventory.fragments.information.InfoFragmentRoute
import com.income.icminventory.fragments.location.ChooseLocationFragment
import com.income.icminventory.fragments.location.ChooseLocationRoute
import com.income.icminventory.fragments.login.LoginFragment
import com.income.icminventory.fragments.login.LoginRoute
import com.income.icminventory.fragments.login.READ_REQUEST_CODE
import com.income.icminventory.fragments.positions_list.empty_list.EmptyListFragment
import com.income.icminventory.fragments.positions_list.empty_list.EmptyListRoute
import com.income.icminventory.fragments.positions_list.scanned_list.ScannedListFragment
import com.income.icminventory.fragments.positions_list.scanned_list.ScannedListRoute
import com.income.icminventory.fragments.scan_positions.ScanPositionsFragment
import com.income.icminventory.views.InfoDialogFragment
import com.income.icminventory.fragments.scan_positions.ScanPositionsRoute
import com.income.icminventory.handling_file.ReadFileController
import com.income.icminventory.handling_file.SaveFileController
import com.income.icminventory.utilities.toast
import com.income.icminventory.utilities.todayDate
import com.raizlabs.android.dbflow.sql.language.Delete
import dagger.android.AndroidInjection
import javax.inject.Inject

const val REQUEST_WRITE_EXTERNAL_STORAGE = 99

abstract class FragmentBase : Fragment() {

    @Inject
    lateinit var dbContext: DBContext
    private var saveController: SaveFileController? = null
    private var readController: ReadFileController? = null
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
            is LoginFragment  -> {
                menu.findItem(R.id.logout).isVisible = false
                menu.findItem(R.id.changeLocation).isVisible = false
                menu.findItem(R.id.moveToScan).isVisible = false
                menu.findItem(R.id.listEmpty).isVisible = false
                menu.findItem(R.id.listDesc).isVisible = false
                menu.findItem(R.id.generateEmptyCSV).isVisible = true
                menu.findItem(R.id.exportToCSV).isVisible = false
            }
            is InfoFragment  -> {
                menu.findItem(R.id.logout).isVisible = true
                menu.findItem(R.id.changeLocation).isVisible = false
                menu.findItem(R.id.moveToScan).isVisible = false
                menu.findItem(R.id.listEmpty).isVisible = false
                menu.findItem(R.id.listDesc).isVisible = false
                menu.findItem(R.id.info).isVisible = false
                menu.findItem(R.id.generateEmptyCSV).isVisible = false
                menu.findItem(R.id.exportToCSV).isVisible = false
            }
            is ChooseLocationFragment -> menu.findItem(R.id.changeLocation).isVisible = false
            is ScanPositionsFragment -> menu.findItem(R.id.moveToScan).isVisible = false
            is EmptyListFragment -> menu.findItem(R.id.listEmpty).isVisible = false
            is ScannedListFragment -> menu.findItem(R.id.listDesc).isVisible = false

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
            R.id.logout -> {
                modeOfSavingCSV = ModeCSV.ExportAndLogout
                requestPermissionAndHandleCSV()
            }
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

    private fun showIfSavedAndLogOut() {
        toast(getString(R.string.saved))
        navigateTo(LoginRoute())
    }

    private fun showIfSavedAndChoseLocation() {
        toast(getString(R.string.saved))
        deleteItemAndLocations()
        navigateTo(ChooseLocationRoute())
    }

    private fun deleteItemAndLocations() {
        Delete.table(Item::class.java)
        dbContext.deleteOldLocations()

    }

    private fun showIfSavedAndSelectFile() {
        toast(getString(R.string.saved))
        deleteItemAndLocations()
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
                ModeCSV.ExportAndLogout -> exportAndLogout()
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
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems() }, { toast(getString(R.string.saved)) }).execute() }, "Export_" + todayDate(activity.baseContext) + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportAndOpenNew() {
        if ((activity as MainActivity).isDemoVersion)
            InfoDialogFragment({ selectCSVFile() }, getString(R.string.version_demo_not_save_file), isWebLink = true).show((activity as MainActivity).fragmentManager, "dialog")
        else
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems() }, { showIfSavedAndSelectFile() }).execute() }, "Export_" + todayDate(activity.baseContext) + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportStartNewEmptyInventory() {
        if ((activity as MainActivity).isDemoVersion)
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { deleteItemAndLocations() }, { navigateTo(ChooseLocationRoute()) }).execute() }, getString(R.string.version_demo_not_save_file), isWebLink = true).show((activity as MainActivity).fragmentManager, "dialog")
        else
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems() }, { showIfSavedAndChoseLocation() }).execute() }, "Export_" + todayDate(activity.baseContext) + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportOrOpenNew() {
        if ((activity as MainActivity).isDemoVersion)
            InfoDialogFragment({ selectCSVFile() }, getString(R.string.version_demo_not_save_file), isWebLink = true).show((activity as MainActivity).fragmentManager, "dialog")
        else
            InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems() }, { toast(getString(R.string.saved)) }).execute() }, "Export_" + todayDate(activity.baseContext) + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun generateEmptyCSV() {
        InfoDialogFragment({ AsyncTaskWithProgress(activity, { saveController?.saveItems(isEmptyFile = true) }, { toast(getString(R.string.saved)) }).execute() }, "Export_empty_" + todayDate(activity.baseContext) + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportAndExitApp() {
        if (dbContext.isEmpty || (activity as MainActivity).isDemoVersion) {
            activity.finish()
            return
        }
        InfoDialogFragment({ AsyncTaskWithProgress(activity as MainActivity, { saveController?.saveItems() }, { showIfSavedAndClosActivity() }).execute() }, "Export_" + todayDate(activity.baseContext) + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }

    private fun exportAndLogout() {
        if (dbContext.isEmpty || (activity as MainActivity).isDemoVersion) {
            navigateTo(LoginRoute())
            return
        }
        InfoDialogFragment({ AsyncTaskWithProgress(activity as MainActivity, { saveController?.saveItems() }, { showIfSavedAndLogOut() }).execute() }, "Export_" + todayDate(activity.baseContext) + ".csv").show((activity as MainActivity).fragmentManager, "dialog")
    }
}