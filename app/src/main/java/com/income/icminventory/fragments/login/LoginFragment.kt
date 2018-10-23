package com.income.icminventory.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.income.icminventory.R
import com.income.icminventory.database.dto.User
import com.income.icminventory.fragments.ModeCSV
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.location.ChooseLocationRoute
import com.income.icminventory.utilities.alsoUnless
import com.income.icminventory.utilities.displayError
import com.income.icminventory.utilities.inflate
import kotlinx.android.synthetic.main.fragment_login.view.btnExportFileAndStartNewEmptyInventory
import kotlinx.android.synthetic.main.fragment_login.etLogin
import kotlinx.android.synthetic.main.fragment_login.view.btnExportFileAndStartNewInventory
import kotlinx.android.synthetic.main.fragment_login.view.btnStartNewInventoryOrContinue

const val READ_REQUEST_CODE = 99

class LoginFragment : FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_login, container) {
                val isEmptyDatabase: Boolean = dbContext.isEmpty
                if (isEmptyDatabase) {
                    btnStartNewInventoryOrContinue.setText(context.getString(R.string.start_new_inventory))
                    btnExportFileAndStartNewInventory.visibility = View.GONE
                } else {
                    btnStartNewInventoryOrContinue.setText(context.getString(R.string.continue_current_inventory))
                    btnExportFileAndStartNewInventory.visibility = View.VISIBLE
                }
                btnExportFileAndStartNewEmptyInventory.setOnClickListener { modeOfSavingCSV = ModeCSV.ExportAndStartEpmtyInventory;exportFileAndStartNewEmptyInventory(isEmptyDatabase) }
                btnExportFileAndStartNewInventory.setOnClickListener { modeOfSavingCSV = ModeCSV.ExportAndOpenNew; exportFileAndStartNewInventory() }
                btnStartNewInventoryOrContinue.setOnClickListener { modeOfSavingCSV = ModeCSV.ExportAndOpenNew; loadOrOpenDatabase(isEmptyDatabase) }
                setHasOptionsMenu(true)
                activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
            }

    private fun validateInput() = alsoUnless({ etLogin.text.trim().isNotEmpty() }) {
        if (etLogin.text.isBlank()) etLogin.text.clear()
        displayError(etLogin, context = activity.baseContext)
    }

    private fun loadOrOpenDatabase(isEmptyDatabase: Boolean) {
        if (!validateInput()) return
        if (isEmptyDatabase) {
            selectCSVFile()
        } else {
            navigateTo(ChooseLocationRoute())
        }
        User(etLogin.text.toString()).save()
    }

    private fun exportFileAndStartNewEmptyInventory(isEmptyDatabase: Boolean) {
        if (!validateInput()) return
        if (isEmptyDatabase) {
            navigateTo(ChooseLocationRoute())
        } else {
            requestPermissionAndHandleCSV()
        }
        User(etLogin.text.toString()).save()
    }

    private fun exportFileAndStartNewInventory() {
        if (!validateInput()) return
        requestPermissionAndHandleCSV()
        User(etLogin.text.toString()).save()
    }
}