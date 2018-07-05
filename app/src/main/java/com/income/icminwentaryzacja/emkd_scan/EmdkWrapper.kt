package com.income.icminwentaryzacja.emkd_scan

import android.content.Context
import com.income.icminwentaryzacja.emkd_scan.EmdkSupport.Companion.initEmdkSupport


object EmdkWrapper {

    @Throws(Exception::class)
    fun checkEmdk(): Boolean {

        return if (android.os.Build.MANUFACTURER.contains("Zebra Technologies") || android.os.Build.MANUFACTURER.contains("Motorola Solutions"))

            true
        else

            false
    }

    @Throws(Exception::class)
    fun initEmdk(ctx: Context) {
        if (checkEmdk())
            initEmdkSupport(ctx)
    }

    @Throws(Exception::class)
    fun registerScannerListener(onReadScan: OnScannerRead) {
        if (checkEmdk())
            EmdkSupport.emdkSupport?.registerScannerListener(onReadScan)
    }

    @Throws(Exception::class)
    fun unregisterScannerListener() {
        if (checkEmdk())
            EmdkSupport.emdkSupport?.unregisterScannerListeners()
    }

    @Throws(Exception::class)
    fun deinitEmkd() {
        if (checkEmdk())
            EmdkSupport.emdkSupport?.onClosed()
    }
}

