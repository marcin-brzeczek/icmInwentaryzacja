package com.income.icminventory.emkd_scan

import android.content.Context
import com.honeywell.aidc.BarcodeReader
import com.income.icminventory.emkd_scan.ScannerType.*

object ScanWrapper {

    private var _typeOfScanner: ScannerType? = null

    @Throws(Exception::class)
    fun initScanner(ctx: Context, typeOfScanner: ScannerType) {
        _typeOfScanner = typeOfScanner

        when (_typeOfScanner) {
            ZEBRA -> EmdkSupport.initEmdkSupport(ctx)
            CIPHERLAB -> CipherLabSupport.initCipherLabSupport(ctx)
            HONEYWELL -> HoneywellSupport.initHoneywellSupport(ctx)
            UNITECH -> UnitechSupport.initUnitechSupport(ctx)
            CAMERA -> {
            }
            else -> {
            }
        }
    }

    fun registerBarcodeListener(onReadScan: OnScannerRead) {
        when (_typeOfScanner) {
            HONEYWELL -> HoneywellSupport.honeywellSupport?.registerBarcodeListener(onReadScan)
        }
    }

    @Throws(Exception::class)
    fun registerScannerListener(onReadScan: OnScannerRead) {
        when (_typeOfScanner) {
            ZEBRA -> EmdkSupport.emdkSupport?.registerScannerListener(onReadScan)
            CIPHERLAB -> CipherLabSupport.cipherLabSupport?.registerScannerListener(onReadScan)
            HONEYWELL -> HoneywellSupport.honeywellSupport?.registerScannerListener(onReadScan)
            UNITECH -> UnitechSupport.unitechSupport?.registerScannerListener(onReadScan)
            CAMERA -> {
            }

            else -> {
            }
        }
    }

    @Throws(Exception::class)
    fun unregisterScannerListener() {
        when (_typeOfScanner) {
            ZEBRA -> EmdkSupport.emdkSupport?.unregisterScannerListeners()
            CIPHERLAB -> CipherLabSupport.cipherLabSupport?.unregisterScannerListeners()
            HONEYWELL -> HoneywellSupport.honeywellSupport?.unregisterScannerListeners()
            UNITECH -> UnitechSupport.unitechSupport?.unregisterScannerListeners()
            CAMERA -> {
            }

            else -> {
            }
        }
    }

    @Throws(Exception::class)
    fun deinitScanner() {
        when (_typeOfScanner) {
            ZEBRA -> EmdkSupport.emdkSupport?.onClosed()
            CIPHERLAB -> CipherLabSupport.cipherLabSupport?.releaseScanner()
            HONEYWELL -> HoneywellSupport.honeywellSupport?.releaseScanner()
            UNITECH -> UnitechSupport.unitechSupport?.releaseScanner()
            CAMERA -> {
            }

            else -> {
            }
        }
    }
}
