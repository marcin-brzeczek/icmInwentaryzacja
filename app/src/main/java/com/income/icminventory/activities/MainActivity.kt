package com.income.icminventory.activities


import android.os.Build
import com.income.icminventory.R
import com.income.icminventory.activities.abstraction.ActivityBase
import com.income.icminventory.emkd_scan.ScannerType
import com.income.icminventory.fragments.report.ReportRoute
import com.income.icminventory.views.ProgressDialogFragment

class MainActivity : ActivityBase() {

    override val layoutId = R.layout.activity_main
    override val startRoute get() = ReportRoute()
    var currentLocation = ""
    var progressDialogFragment: ProgressDialogFragment? = null
    var isActivityResume = false
    var isDialogShowed = false

    override fun onStart() {
        super.onStart()
        progressDialogFragment = ProgressDialogFragment()
    }

    /*właściwość ustawiajaca skaner ZEBRA,CIPHERLAB, CAMERA*/
    var scannerType = ScannerType.HONEYWELL

    /*właściwość deklarująca czy wersja jest DEMO (bez opcji exportu pliku csv)*/
    val isDemoVersion = false

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
        /*Podłączenie automatyczne skanera z wykryciem urządzenia w wersji Demo*/
        if (isDemoVersion) {
            if (Build.MANUFACTURER.contains("Zebra Technologies") || Build.MANUFACTURER.contains("Motorola Solutions"))
                scannerType = ScannerType.ZEBRA
            if (Build.MANUFACTURER.contains("Mobiwire"))
                scannerType = ScannerType.CIPHERLAB
        }
    }
}