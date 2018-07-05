package com.income.icminwentaryzacja.emkd_scan

import android.content.Context
import com.income.icminwentaryzacja.emkd_scan.ScannerType.ZEBRA
import com.income.icminwentaryzacja.emkd_scan.ScannerType.CIPHERLAB
import com.income.icminwentaryzacja.emkd_scan.ScannerType.CAMERA

object ScanWrapper {

    private var _typeOfScanner: ScannerType? = null

    @Throws(Exception::class)
    fun initScanner(ctx: Context, typeOfScanner: ScannerType) {
        _typeOfScanner = typeOfScanner

        when (_typeOfScanner) {
            ZEBRA -> EmdkSupport.initEmdkSupport(ctx)
            CIPHERLAB -> CipherLabSupport.initCipherLabSupport(ctx)
            CAMERA -> {}
            else -> {
            }
        }
    }

    @Throws(Exception::class)
    fun registerScannerListener(onReadScan: OnScannerRead) {
        when (_typeOfScanner) {
            ZEBRA -> EmdkSupport.emdkSupport?.registerScannerListener(onReadScan)
            CIPHERLAB -> CipherLabSupport.cipherLabSupport?.registerScannerListener(onReadScan)
            CAMERA -> {}

            else -> {
            }
        }
    }

    @Throws(Exception::class)
    fun unregisterScannerListener() {
        when (_typeOfScanner) {
            ZEBRA -> EmdkSupport.emdkSupport?.unregisterScannerListeners()
            CIPHERLAB -> CipherLabSupport.cipherLabSupport?.unregisterScannerListeners()
            CAMERA -> {}

            else -> {
            }
        }
    }

    @Throws(Exception::class)
    fun deinitScanner() {
        when (_typeOfScanner) {
            ZEBRA -> EmdkSupport.emdkSupport?.onClosed()
            CIPHERLAB -> CipherLabSupport.cipherLabSupport?.releaseScanner()
            CAMERA -> {}

            else -> {
            }
        }
    }
}
