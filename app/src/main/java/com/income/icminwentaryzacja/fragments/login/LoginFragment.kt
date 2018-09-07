package com.income.icminwentaryzacja.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.dto.User
import com.income.icminwentaryzacja.fragments.ModeCSV
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.location.ChooseLocationRoute
import com.income.icminwentaryzacja.utilities.alsoUnless
import com.income.icminwentaryzacja.utilities.displayError
import com.income.icminwentaryzacja.utilities.inflate
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
            btnExportFileAndStartNewEmptyInventory.setOnClickListener { exportFileAndStartNewEmptyInventory(isEmptyDatabase); modeOfSavingCSV = ModeCSV.ExportAndStartEpmtyInventory }
            btnExportFileAndStartNewInventory.setOnClickListener { exportFileAndStartNewInventory(); modeOfSavingCSV = ModeCSV.ExportAndOpenNew }
            btnStartNewInventoryOrContinue.setOnClickListener { loadOrOpenDatabase(isEmptyDatabase); modeOfSavingCSV = ModeCSV.ExportAndOpenNew }
            setHasOptionsMenu(true)
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
    }

    private fun exportFileAndStartNewInventory() {
        if (!validateInput()) return
        requestPermissionAndHandleCSV()
        User(etLogin.text.toString()).save()
    }
}