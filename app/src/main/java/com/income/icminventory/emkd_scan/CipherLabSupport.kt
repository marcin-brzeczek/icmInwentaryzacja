package com.income.icminventory.emkd_scan

import com.cipherlab.barcode.ReaderManager
import com.cipherlab.barcode.decoder.KeyboardEmulationType
import com.cipherlab.barcode.decoderparams.ReaderOutputConfiguration
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log

class CipherLabSupport @Throws(Exception::class)

private constructor(private val _ctx: Context) {
    private var filter: IntentFilter? = null
    private var rm: ReaderManager? = null
    @Volatile
    private var _onRead: OnScannerRead? = null
    private var dataReceiver: BroadcastReceiver? = null

    private val receiver: BroadcastReceiver
        get() = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (intent.action == "com.cipherlab.barcodebaseapi.PASS_DATA_2_APP") {
                    val data = intent.getStringExtra("Decoder_Data")
                    _onRead!!.onReadData(data)
                }
            }
        }

    private fun disableInputMode() {
        val settings = ReaderOutputConfiguration()
        settings.enableKeyboardEmulation = KeyboardEmulationType.None
    }

    init {
        try {
            if (cipherLabSupport == null) {
                rm = ReaderManager.InitInstance(_ctx)
                disableInputMode()
            }
        } catch (e: Exception) {
            Log.e("INV", e.message, e)
            throw e
        }

    }

    /* rejestracja listenera odbywa się na obiekcie _onRead */
    fun registerScannerListener(onRead: OnScannerRead) {
        _onRead = onRead
        filter = IntentFilter()
        filter!!.addAction("com.cipherlab.barcodebaseapi.PASS_DATA_2_APP")
        dataReceiver = receiver
        _ctx.registerReceiver(dataReceiver, filter)
    }

    /* wyrejestrowanie listenera przy przypisaniu listenera na null */
    fun unregisterScannerListeners() {
        _onRead = null
        _ctx.unregisterReceiver(dataReceiver)
    }



    fun enableScanner() {
        if (rm != null && !rm!!.GetActive())
            rm!!.SetActive(true)
    }

    fun disableScanner() {
        if (rm != null && rm!!.GetActive())
            rm!!.SetActive(false)
    }

    fun releaseScanner() {
        //		new AsynTaskEnableScannerWhenExitProgram().execute();
        if (rm != null) {
            rm!!.Release()
            rm = null
        }
    }


    companion object {

        var cipherLabSupport: CipherLabSupport? = null
            private set

        @Throws(Exception::class)
        fun initCipherLabSupport(ctx: Context): CipherLabSupport {
            if (cipherLabSupport == null)
                cipherLabSupport = CipherLabSupport(ctx)

            return cipherLabSupport as CipherLabSupport
        }
    }
}