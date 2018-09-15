package com.income.icminwentaryzacja.activities

import android.os.Build
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.abstraction.ActivityBase
import com.income.icminwentaryzacja.emkd_scan.ScannerType
import com.income.icminwentaryzacja.fragments.report.ReportRoute

class MainActivity : ActivityBase() {

    override val layoutId = R.layout.activity_main
    override val startRoute get() = ReportRoute()
    var currentLocation = ""

    /*właściwość ustawiajaca skaner ZEBRA,CIPHERLAB, CAMERA*/
    var scannerType = ScannerType.CAMERA

    /*właściwość deklarująca czy wersja jest DEMO (bez opcji exportu pliku csv)*/
    val isDemoVersion = true

    override fun onResume() {
        super.onResume()

        /*Podłączenie automatyczne skanera z wykryciem urządzenia w wersji Demo*/
        if (isDemoVersion) {
            if (Build.MANUFACTURER.contains("Zebra Technologies") || Build.MANUFACTURER.contains("Motorola Solutions"))
                scannerType = ScannerType.ZEBRA
            if (Build.MANUFACTURER.contains("Mobiwire"))
                scannerType = ScannerType.CIPHERLAB
        }
    }
}