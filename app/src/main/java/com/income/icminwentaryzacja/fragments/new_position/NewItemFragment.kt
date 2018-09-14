package com.income.icminwentaryzacja.fragments.new_position

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.emkd_scan.OnScannerRead
import com.income.icminwentaryzacja.emkd_scan.ScanWrapper
import com.income.icminwentaryzacja.emkd_scan.ScannerType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.utilities.alsoUnless
import com.income.icminwentaryzacja.utilities.displayError
import kotlinx.android.synthetic.main.fragment_new_position.*

class NewItemFragment : FragmentBase(), OnScannerRead {
    var currentAmount: Double = 0.0
    private var amount = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_position, container, false).apply {
            try {
                ScanWrapper.initScanner(activity.baseContext, ScannerType.CIPHERLAB)
            } catch (e: Exception) {
                exceptionMessage(context.getString(R.string.error_init_scanner) + e.message)
            }
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemCode: String? = arguments.getString(NEW_ITEM_CODE)

        tvLocation.text = (activity as MainActivity).currentLocation
        etCode.setText(itemCode)

        btnSave.setOnClickListener { saveItem() }
        setHasOptionsMenu(true)

        imgRemoveAmount.setOnClickListener { setAmount();tvAmount.setText(if (currentAmount > 1.0) (--currentAmount).toString() + "" else "1.0") }
        imgAddAmount.setOnClickListener { setAmount();tvAmount.setText((++currentAmount).toString() + "") }
    }

    override fun onResume() {
        super.onResume()
        try {
            ScanWrapper.registerScannerListener(this)
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.error_registry_scanner) + e.message)
        }
    }

    private fun setTextIfHasFocus(scannedData: String) {
        listOf(etCode, etSupportCode, etName).forEach {
            if (it.hasFocus()) {
                it.setText(scannedData)
                it.focusSearch(View.FOCUS_DOWN)?.requestFocus()
                return
            }
        }
    }

    override fun onPause() {
        super.onPause()
        try {
            ScanWrapper.unregisterScannerListener()
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.error_unregistry_scanner) + e.message)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        try {
            ScanWrapper.deinitScanner()
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.cant_release_scanner) + e.message)
        }
    }

    override fun onReadData(data: String) {
        setTextIfHasFocus(data)
    }

    override fun onReadStatus(text: String) {
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show();
    }

    private fun saveItem() {
        if (!validateInput()) return
        Item(code = etCode.text.toString().trim(),
                supportCode = etSupportCode.text.toString().trim(),
                shortName = "",
                name = etName.text.toString().trim(),
                oldLocation = tvLocation.text.toString(),
                startNumber = 0.0,
                endNumber = tvAmount.text.toString().toDouble(),
                itemState = getString(R.string.handle),
                user = ""
        ).insert()
        Toast.makeText(activity.baseContext, getString(R.string.saved), Toast.LENGTH_SHORT).show()
        navigateBack()
    }

    private fun validateInput() = alsoUnless({ etCode.text.trim().isNotEmpty() && etName.text.trim().isNotEmpty() }) {
        if (etCode.text.isBlank()) etCode.text.clear()
        if (etName.text.isBlank()) etName.text.clear()
        displayError(etCode, etName, context = activity.baseContext)
    }

    private fun setAmount() {
        amount = if (tvAmount.getText().toString() != null && tvAmount.getText().toString().length > 1)
            tvAmount.getText().toString()
        else
            "1.0"
        currentAmount = java.lang.Double.valueOf(amount)
    }
}