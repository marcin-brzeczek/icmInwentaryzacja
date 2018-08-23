package com.income.icminwentaryzacja.fragments.scan_positions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.database.dto.Item_Table
import com.income.icminwentaryzacja.emkd_scan.OnScannerRead
import com.income.icminwentaryzacja.emkd_scan.ScanWrapper
import com.income.icminwentaryzacja.emkd_scan.ScannerType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.choose_location.ChooseLocationRoute
import com.income.icminwentaryzacja.fragments.new_position.NewItemRoute
import com.income.icminwentaryzacja.fragments.positions_list.empty_list.EmptyListRoute
import com.income.icminwentaryzacja.fragments.positions_list.scanned_list.ScannedListRoute
import kotlinx.android.synthetic.main.fragment_scan_positions.*
import kotlinx.android.synthetic.main.fragment_scan_positions.view.*

class ScanPositionsFragment : FragmentBase(), OnScannerRead {

     var locationName: String=""

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

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        locationName = arguments.getString(LOCATION_NAME)
        addNewItem.setOnClickListener { navigateTo(NewItemRoute(locationName =locationName)) }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> activity.finish()
            R.id.listEmpty -> navigateTo(EmptyListRoute(locationName))
            R.id.listDesc -> navigateTo(ScannedListRoute(locationName))
            R.id.exportToCSV -> requestPermissionOrSaveCSV()
            R.id.changeLocation -> navigateTo(ChooseLocationRoute())
        }
        return super.onOptionsItemSelected(item)
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
        val finishData = if (data.contains(enterSuffix)) data.removeSuffix(enterSuffix) else data
        getPositionByCode(finishData)
    }

    override fun onReadStatus(text: String) {
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show();
    }

    private fun getPositionByCode(codew: String) {
        val item: Item? = dbContext.items.where(Item_Table.code.eq(codew)).and(Item_Table.oldLocation.eq(locationName)).querySingle()
        item?.let {
            sectionLogo.visibility = View.GONE
            sectionScann.visibility = View.VISIBLE
            tvName.setText(it.name)
            tvAmount.setText((++it.endNumber).toString())
            tvLokalization.setText(it.oldLocation)
            it.save()
        } ?: showNewPositionDialog(editTextEAN.text.toString())
    }
    fun showNewPositionDialog(codePos: String) {
        NewPositionDialogFragment({ navigateTo(NewItemRoute(codePos, locationName)) }).show((activity as MainActivity).fragmentManager, "dialog")
    }

}