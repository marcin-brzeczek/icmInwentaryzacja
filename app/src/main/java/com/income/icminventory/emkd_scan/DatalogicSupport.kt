package com.income.icminventory.emkd_scan

import android.content.Context
import android.util.Log
import com.datalogic.decode.BarcodeManager
import com.datalogic.decode.ReadListener
import com.datalogic.decode.configuration.ScannerProperties

class DatalogicSupport @Throws(Exception::class)

private constructor(private val _ctx: Context) {

    private var barcodeManager: BarcodeManager? = null
    private var configuration: ScannerProperties? = null
    private var isFirstInitialized = false


    @Volatile
    private var _onRead: OnScannerRead? = null
    private var readListener: ReadListener? = null

    private val listener
        get() = ReadListener { data -> _onRead?.onReadData(data?.text) }

    init {
        try {
            if (datalogicSupport == null) {
                isFirstInitialized = true
            }
        } catch (e: Exception) {
            Log.e("INV", e.message, e)
            throw e
        }
    }

    /* rejestracja listenera odbywa się na obiekcie _onRead */
    fun registerScannerListener(onRead: OnScannerRead) {
        if (barcodeManager == null) {
            barcodeManager = BarcodeManager()
            if (isFirstInitialized) {
                configuration = ScannerProperties.edit(barcodeManager)
                configuration?.keyboardWedge?.onlyOnFocus?.set(true)
                configuration?.store(barcodeManager, true)
                isFirstInitialized = false
            }
        }
        _onRead = onRead
        readListener = listener
        barcodeManager?.addReadListener(readListener)
    }

    /* wyrejestrowanie listenera przy przypisaniu listenera na null */
    fun unregisterScannerListeners() {
        _onRead = null
        if (barcodeManager != null) {
            barcodeManager?.removeReadListener(readListener)
            barcodeManager = null
        }
    }

    fun releaseScanner() {}

    companion object {

        var datalogicSupport: DatalogicSupport? = null
            private set

        @Throws(Exception::class)
        fun initDatalogicSupport(ctx: Context): DatalogicSupport {
            if (datalogicSupport == null)
                datalogicSupport = DatalogicSupport(ctx)

            return datalogicSupport as DatalogicSupport
        }
    }
}