package com.income.icminwentaryzacja.fragments.scan_positions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.DBContext
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.database.dto.Item_Table
import com.income.icminwentaryzacja.emkd_scan.OnScannerRead
import com.income.icminwentaryzacja.emkd_scan.ScanWrapper
import com.income.icminwentaryzacja.emkd_scan.ScannerType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import kotlinx.android.synthetic.main.fragment_scan_positions.*
import kotlinx.android.synthetic.main.fragment_scan_positions.view.*

import javax.inject.Inject



class ScanPositionsFragment : FragmentBase(), OnScannerRead {

    @Inject
    lateinit var dbContext: DBContext


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_scan_positions, container, false).apply {
            try {
                ScanWrapper.initScanner(activity.baseContext, ScannerType.ZEBRA)
            } catch (e: Exception) {
                exceptionMessage("Błąd w inicjalizacji  Skanera: " + e.message)
            }
                btnNewPosition.setOnClickListener(View.OnClickListener {  })
            btnSearchPosition.setOnClickListener(View.OnClickListener {  })
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
        val enterSuffix = "\n"
        val finishData = if(data.contains(enterSuffix)) data.removeSuffix(enterSuffix) else data
        getPositionByCode(finishData)
    }

    override fun onReadStatus(text: String) {
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show();
    }

    private fun getPositionByCode(codew: String) {
        val item: Item? = dbContext.items.where(Item_Table.code.eq(codew)).querySingle()
        item?.let {
            sectionName.visibility = View.VISIBLE
            sectionAmount.visibility = View.VISIBLE
            tvName.setText(it.name)
            tvAmount.setText((++it.endNumber).toString())
            tvLokalization.setText(it.oldLocation)
//            it.endNumber = ++it.endNumber
            it.save()
        }
    }
}


