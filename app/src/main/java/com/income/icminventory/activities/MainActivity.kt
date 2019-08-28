package com.income.icminventory.activities

import android.os.Build
import android.os.Bundle
import com.honeywell.aidc.AidcManager
import com.honeywell.aidc.BarcodeReader
import com.honeywell.aidc.UnsupportedPropertyException
import com.income.icminventory.R
import com.income.icminventory.activities.abstraction.ActivityBase
import com.income.icminventory.emkd_scan.ScannerType
import com.income.icminventory.fragments.report.ReportRoute
import com.income.icminventory.views.ProgressDialogFragment
import org.jetbrains.anko.toast

class MainActivity : ActivityBase() {

    private var manager: AidcManager? = null

    override val layoutId = R.layout.activity_main
    override val startRoute get() = ReportRoute()
    var currentLocation = ""
    var currentUser = ""
    var scannedLocation = ""
    var progressDialogFragment: ProgressDialogFragment? = null
    var isActivityResume = false
    var isDialogShowed = false

    /*właściwość ustawiajaca skaner ZEBRA,CIPHERLAB, CAMERA*/
    var scannerType = ScannerType.ZEBRA

    /*właściwość deklarująca czy wersja jest DEMO (bez opcji exportu pliku csv)*/
    val isDemoVersion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*Podłączenie automatyczne skanera z wykryciem urządzenia w wersji Demo*/
        if (isDemoVersion) {
            if (Build.MANUFACTURER.contains("Zebra Technologies") || Build.MANUFACTURER.contains("Motorola Solutions"))
                scannerType = ScannerType.ZEBRA
            if (Build.MANUFACTURER.contains("Mobiwire"))
                scannerType = ScannerType.CIPHERLAB
            if (Build.MANUFACTURER.contains("Honeywell"))
                scannerType = ScannerType.HONEYWELL
            if (Build.MANUFACTURER.contains("Unitech"))
                scannerType = ScannerType.UNITECH
            if (Build.MANUFACTURER.contains("Datalogic"))
                scannerType = ScannerType.DATALOGIC
        }

        if (scannerType == ScannerType.HONEYWELL)
            AidcManager.create(baseContext, object : AidcManager.CreatedCallback {
                override fun onCreated(aidcManager: AidcManager?) {
                    manager = aidcManager
                    barcodeReader = manager!!.createBarcodeReader()
                    try {
                        barcodeReader?.setProperty(BarcodeReader.PROPERTY_TRIGGER_CONTROL_MODE,
                                BarcodeReader.TRIGGER_CONTROL_MODE_AUTO_CONTROL)
                    } catch (e: UnsupportedPropertyException) {
                        baseContext.toast("Failed to apply properties")
                    }
                }
            })
    }

    companion object {
        var barcodeReader: BarcodeReader? = null
    }

    override fun onStart() {
        super.onStart()
        progressDialogFragment = ProgressDialogFragment()
    }

    override fun onPause() {
        super.onPause()
        progressDialogFragment?.let {
            if (isDialogShowed) {
                it.dismiss()
                isDialogShowed = false
            }
        }
        isActivityResume = false
    }

    override fun onResume() {
        super.onResume()
        isActivityResume = true
    }

    override fun onDestroy() {
        super.onDestroy()
        if (scannerType == ScannerType.HONEYWELL) {
            if (barcodeReader != null) {
                barcodeReader?.close()
                barcodeReader = null
            }
            if (manager != null) {
                manager?.close()
            }
        }
    }
}