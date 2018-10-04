package com.income.icminventory.emkd_scan

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.honeywell.aidc.*
import com.income.icminventory.activities.MainActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class HoneywellSupport @Throws(Exception::class)

private constructor(private val _ctx: Context) {

    private var barcodeReader: BarcodeReader? = null
    @Volatile
    private var _onRead: OnScannerRead? = null

    private lateinit var _barcodeListener: BarcodeReader.BarcodeListener

    private val barcodeListener: BarcodeReader.BarcodeListener
        get() = object : BarcodeReader.BarcodeListener {
            override fun onFailureEvent(barcodeFailureEvent: BarcodeFailureEvent?) {
                _onRead?.exceptionMessage(barcodeFailureEvent?.timestamp)
            }

            override fun onBarcodeEvent(event: BarcodeReadEvent) {
                doAsync {
                    uiThread {
                        _onRead?.onReadData(event.barcodeData)
                    }
                }
            }
        }

    init {
        try {
            if (honeywellSupport == null) {
              barcodeReader =  MainActivity.barcodeReader

            }
        } catch (e: Exception) {
            Log.e("INV", e.message, e)
            throw e
        }
    }

    /* rejestracja listenera odbywa się na obiekcie _onRead */
    fun registerScannerListener(onRead: OnScannerRead) {
        if (barcodeReader != null) {
            try {
                barcodeReader!!.claim()
            } catch (e: ScannerUnavailableException) {
                e.printStackTrace()
                Toast.makeText(_ctx, "Scanner unavailable", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /* wyrejestrowanie listenera przy przypisaniu listenera na null */
    fun unregisterScannerListeners() {
        _onRead = null
        if (barcodeReader != null) {
            barcodeReader!!.removeBarcodeListener(_barcodeListener)
            barcodeReader!!.release()
        }
    }


    fun releaseScanner() {
//        if (barcodeReader != null) {
//            barcodeReader!!.close()
//            barcodeReader = null
//        }
//        if (manager != null)
//            manager!!.close()
    }

    fun registerBarcodeListener(onReadScan: OnScannerRead) {
        _onRead = onReadScan
        _barcodeListener = barcodeListener
        barcodeReader!!.addBarcodeListener(_barcodeListener)
    }


    companion object {

        var honeywellSupport: HoneywellSupport? = null
            private set

        @Throws(Exception::class)
        fun initHoneywellSupport(ctx: Context): HoneywellSupport {
            if (honeywellSupport == null)
                honeywellSupport = HoneywellSupport(ctx)

            return honeywellSupport as HoneywellSupport
        }
    }
}