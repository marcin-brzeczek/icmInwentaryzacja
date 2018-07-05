package com.income.icminwentaryzacja.fragments.scan_positions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.emkd_scan.EmdkWrapper
import com.income.icminwentaryzacja.emkd_scan.OnScannerRead
import com.income.icminwentaryzacja.emkd_scan.ScanWrapper
import com.income.icminwentaryzacja.emkd_scan.ScannerType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import kotlinx.android.synthetic.main.fragment_scan_positions.*

class ScanPositionsFragment : FragmentBase(), OnScannerRead {

    //    @Inject
//    lateinit var databaseContext: DBContext
    private val items = mutableListOf<Item>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_scan_positions, container, false).apply {
            try {
                ScanWrapper.initScanner(activity.baseContext, ScannerType.CIPHERLAB)
            } catch (e: Exception) {
                exceptionMessage("Błąd w inicjalizacji  Skanera: " + e.message)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        try {
            ScanWrapper.registerScannerListener(this)
        } catch (e: Exception) {
            exceptionMessage("Błąd w trakcie rejestracji Skanera: " + e.message)
        }
    }

    public override fun onPause() {
        super.onPause()
        try {
            ScanWrapper.unregisterScannerListener()
        } catch (e: Exception) {
            exceptionMessage("Błąd w trakcie wyrejestrowania Skanera: " + e.message)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        try {
            ScanWrapper.deinitScanner()
        } catch (e: Exception) {
            exceptionMessage("Nie można zwolnić obiektu Skanera: " + e.message)
        }
    }

    override fun onReadData(data: String) {
        editTextEAN.setText(data)
    }

    override fun onReadStatus(text: String) {
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show();
    }


}


