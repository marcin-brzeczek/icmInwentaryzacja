package com.income.icminventory.fragments.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.income.icminventory.R
import com.income.icminventory.activities.MainActivity
import com.income.icminventory.database.dto.Location
import com.income.icminventory.emkd_scan.OnScannerRead
import com.income.icminventory.emkd_scan.ScanWrapper
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.scan_positions.ScanPositionsRoute
import com.income.icminventory.utilities.alsoUnless
import com.income.icminventory.utilities.displayError
import com.income.icminventory.utilities.inflate
import com.income.icminventory.utilities.toast
import kotlinx.android.synthetic.main.fragment_new_location.*

class NewLocationFragment : FragmentBase(), OnScannerRead {

    private var isScannedLocalization = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_new_location, container) {
            setActionBar(this@NewLocationFragment)
            setHasOptionsMenu(true)
            try {
                ScanWrapper.initScanner(activity.baseContext, (activity as MainActivity).scannerType)
            } catch (e: Exception) {
                exceptionMessage(context.getString(R.string.error_init_scanner) + e.message)
            }

        }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setLocalizationIfScanned()
    }

    override fun onStart() {
        super.onStart()
        ScanWrapper.registerBarcodeListener(this)
    }

    override fun onResume() {
        super.onResume()
        try {
            ScanWrapper.registerScannerListener(this)
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.error_registry_scanner) + e.message)
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

    override fun onReadData(data: String) {
        etName.setText(data)
    }

    override fun onReadStatus(text: String) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        try {
            ScanWrapper.deinitScanner()
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.cant_release_scanner) + e.message)
        }
    }
    private fun setListeners() {
        btnSave.setOnClickListener { saveLocation() }
        etName.setOnEditorActionListener { textView, action, event ->
            var handled = false
            if (action == EditorInfo.IME_ACTION_DONE) {
                saveLocation()
                handled = true
            }
            handled
        }
    }

    private fun setLocalizationIfScanned() {
        val scannedLocalizationName = (activity as MainActivity).scannedLocation
        isScannedLocalization = scannedLocalizationName.isNotEmpty()
        if (isScannedLocalization) {
            etName.setText(scannedLocalizationName)
        }
    }

    private fun saveLocation() {
        if (!validateInput()) return
        if (dbContext.locations.queryList().map { it.name }.contains(etName.text.toString())) {
            toast(getString(R.string.location_already_exists))
            return
        }
        Location(name = etName.text.toString().trim()).insert()
        toast(getString(R.string.saved))
        if (isScannedLocalization) {
            (activity as MainActivity).currentLocation = etName.text.toString()
            (activity as MainActivity).scannedLocation = ""
            navigateTo(ScanPositionsRoute())
        } else {
            navigateBack()
        }
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show()
    }

    private fun validateInput() = alsoUnless({ etName.text.trim().isNotEmpty() }) {
        if (etName.text.isBlank()) etName.text.clear()
        displayError(etName, context = activity.baseContext)
    }
}