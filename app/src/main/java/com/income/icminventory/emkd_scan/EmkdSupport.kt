package com.income.icminventory.emkd_scan

import android.content.Context
import android.util.Log
import com.symbol.emdk.EMDKManager
import com.symbol.emdk.EMDKManager.EMDKListener
import com.symbol.emdk.barcode.BarcodeManager
import com.symbol.emdk.barcode.ScanDataCollection
import com.symbol.emdk.barcode.Scanner
import com.symbol.emdk.barcode.Scanner.DataListener
import com.symbol.emdk.barcode.Scanner.StatusListener
import com.symbol.emdk.barcode.StatusData
import android.os.AsyncTask
import com.symbol.emdk.barcode.ScannerException
import com.symbol.emdk.barcode.ScannerResults


class EmdkSupport @Throws(Exception::class)

private constructor(private val _ctx: Context) : EMDKListener, StatusListener, DataListener {
        private var _emdkManager: EMDKManager? = null
        private var _barcodeManager: BarcodeManager? = null
        @Volatile
        private var _scanner: Scanner? = null
        @Volatile
        private var _onRead: OnScannerRead? = null
        internal var isScannerFinishRead = true

        init {
            try {
            if (emdkSupport == null)

                EMDKManager.getEMDKManager(_ctx, this)

            } catch (e: Exception) {
                Log.e("INV", e.message, e)
                throw e
            }

        }

        override fun onData(scanDataCollection: ScanDataCollection) {
            AsyncDataUpdate().execute(scanDataCollection)
        }

        override fun onStatus(statusData: StatusData) {
            AsyncStatusUpdate().execute(statusData)
        }

        override
        fun onClosed() {

            if (_emdkManager != null) {
                if (_barcodeManager != null) {
                    _barcodeManager = null
                }
                _emdkManager = null
            }
        }

        override fun onOpened(emdkManager: EMDKManager) {
            _emdkManager = emdkManager

            try {
                if (_scanner == null) {
                    _barcodeManager = _emdkManager!!.getInstance(EMDKManager.FEATURE_TYPE.BARCODE) as BarcodeManager
                    _scanner = _barcodeManager!!.getDevice(BarcodeManager.DeviceIdentifier.DEFAULT)

                    _scanner!!.triggerType = Scanner.TriggerType.HARD
                    _scanner!!.enable()

                    onScannerReadChanged()
                }
            } catch (se: ScannerException) {
                if (_onRead != null)
                    _onRead!!.exceptionMessage("Błąd w trakcie uzyskiwania " + "dostępu do Skanera: " + se.message)
            }

        }

        private fun onScannerReadChanged() {
            if (_scanner == null)
                return

            try {
                if (_onRead != null) {
                    _scanner!!.addDataListener(this)
                    _scanner!!.addStatusListener(this)
                    _scanner!!.enable()
                    if (!_scanner!!.isReadPending)
                        _scanner!!.read()

                    Log.e("INFO SCANNER", "ENABLED")
                } else {
                    if (_scanner!!.isReadPending)
                        _scanner!!.cancelRead()

                    _scanner!!.removeDataListener(this)
                    _scanner!!.removeStatusListener(this)
                    _scanner!!.disable()

                    Log.e("INFO SCANNER", "DISABLED")
                }
            } catch (e: Exception) {
                Log.e("SCANNER", e.message, e)
                if (_onRead != null)
                    _onRead!!.exceptionMessage("Błąd w trakcie ustawiania " + "odbiorników Skanera " + e.message)
            }

        }

        //    /* rejestracja listenera odbywa się na obiekcie _onRead */
        fun registerScannerListener(onRead: OnScannerRead) {
            _onRead = onRead
            onScannerReadChanged()
        }

        //
//    /* wyrejestrowanie listenera przy przypisaniu listenera na null */
        fun unregisterScannerListeners() {
            _onRead = null
            onScannerReadChanged()
        }

        inner class AsyncDataUpdate : AsyncTask<ScanDataCollection, Void, String>() {

            override fun doInBackground(vararg params: ScanDataCollection): String {

                var statusStr = ""

                try {
                    // TODO:test bez poniższej linii
                    // _scanner.read();
                    val scanDataCollection = params[0]

                    if (scanDataCollection != null && scanDataCollection.result == ScannerResults.SUCCESS) {
                        val scanData = scanDataCollection.scanData

                        for (data in scanData) {

                            val barcodeData = data.data
                            val labelType = data.labelType
                            statusStr = barcodeData // + " " + labelType;
                            Log.e("scanner data", "status: $statusStr")
                        }
                    }
                } catch (se: Exception) {
                    if (_onRead != null) {
                        _onRead!!.exceptionMessage("Błąd w trakcie zczytywania kodu :" + se.message)
                    }
                }

                return statusStr
            }

            override fun onPostExecute(result: String) {

                Log.e("SCANNER READ", result)
                if (_onRead != null)
                    _onRead!!.onReadData(result)
            }
        }

        inner class AsynTaskStateIdle : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg params: Void): Void? {
                try {
                    _scanner!!.read()
            } catch (e: ScannerException) {
                    e.printStackTrace()
                }

                return null
            }
        }

        @Synchronized
        private fun runScanAfterIDLE() {
            AsynTaskStateIdle().execute()
        }

        // TODO:analiza statusów przesyłanych przez skaner. Jak nie pomoże to DEBUG
        // z breakpointami w każdym case
        inner class AsyncStatusUpdate : AsyncTask<StatusData, Void, String>() {

            override fun doInBackground(vararg params: StatusData): String {
                var statusStr = ""
                val statusData = params[0]
                val state = statusData.state

                /* Different states of Scanner */
                when (state) {

                    StatusData.ScannerStates.IDLE -> {

                        statusStr = "The Scanner enabled and its idle"
                        /* jeśli IDLE to próbuj czytać dalej */
                        if (!_scanner!!.isReadPending && _onRead != null)
                            runScanAfterIDLE()
                    }
                    StatusData.ScannerStates.SCANNING -> statusStr = "Scanning.."
                    StatusData.ScannerStates.WAITING -> statusStr = "Waiting for trigger press.."
                    StatusData.ScannerStates.DISABLED -> statusStr = "Scanner is not enabled"
                    else -> statusStr = "DEF"
                }
                Log.e("SCANNER STATUS", statusStr)
                return statusStr
            }

            override fun onPostExecute(result: String) {
                if (_onRead != null)
                    _onRead!!.onReadStatus(result)
            }
        }


    companion object {

        var emdkSupport: EmdkSupport? = null
            private set


        @Throws(Exception::class)
        fun initEmdkSupport(ctx: Context): EmdkSupport {
            if (emdkSupport == null)
                emdkSupport = EmdkSupport(ctx)

            return emdkSupport as EmdkSupport
        }
    }
}