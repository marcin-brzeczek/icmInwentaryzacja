package com.income.icminventory.emkd_scan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.device.ScanManager
import android.device.scanner.configuration.PropertyID
import android.util.Log

const val SCAN_ACTION = ScanManager.ACTION_DECODE

class UnitechSupport @Throws(Exception::class)

private constructor(private val _ctx: Context) {

    private var scanManager: ScanManager? = null

    @Volatile
    private var _onRead: OnScannerRead? = null
    private var dataReceiver: BroadcastReceiver? = null

    private val receiver: BroadcastReceiver
        get() = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val barcode = intent.getByteArrayExtra(ScanManager.DECODE_DATA_TAG)
                val barcodelen = intent.getIntExtra(ScanManager.BARCODE_LENGTH_TAG, 0)
                val data = String(barcode, 0, barcodelen)
                _onRead!!.onReadData(data)
            }
        }

    init {
        try {
            if (unitechSupport == null) {
            }
        } catch (e: Exception) {
            Log.e("INV", e.message, e)
            throw e
        }
    }

    /* rejestracja listenera odbywa się na obiekcie _onRead */
    fun registerScannerListener(onRead: OnScannerRead) {
        _onRead = onRead
        dataReceiver = receiver
        scanManager = ScanManager()
        scanManager?.openScanner()
        scanManager?.switchOutputMode(0)
        val filter = IntentFilter()
        val idbuf = intArrayOf(PropertyID.WEDGE_INTENT_ACTION_NAME, PropertyID.WEDGE_INTENT_DATA_STRING_TAG)
        val value_buf = scanManager?.getParameterString(idbuf)
        if (value_buf != null && value_buf[0] != null && value_buf[0] != "") {
            filter.addAction(value_buf[0])
        } else {
            filter.addAction(SCAN_ACTION)
        }
        _ctx.registerReceiver(dataReceiver, filter)
    }

    /* wyrejestrowanie listenera przy przypisaniu listenera na null */
    fun unregisterScannerListeners() {
        _onRead = null
        if (scanManager != null)
            scanManager?.stopDecode()

        _ctx.unregisterReceiver(dataReceiver)
    }

    fun releaseScanner() {
//        if (scanManager != null)
//            scanManager?.stopDecode()
    }

    companion object {

        var unitechSupport: UnitechSupport? = null
            private set

        @Throws(Exception::class)
        fun initUnitechSupport(ctx: Context): UnitechSupport {
            if (unitechSupport == null)
                unitechSupport = UnitechSupport(ctx)

            return unitechSupport as UnitechSupport
        }
    }
}