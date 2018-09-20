package com.income.icminventory.fragments.scan_positions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminventory.R
import com.income.icminventory.activities.MainActivity
import com.income.icminventory.database.dto.Item
import com.income.icminventory.database.dto.Item_Table
import com.income.icminventory.emkd_scan.OnScannerRead
import com.income.icminventory.emkd_scan.ScanWrapper
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.new_position.NewItemRoute
import com.income.icminventory.views.NewPositionDialogFragment
import kotlinx.android.synthetic.main.fragment_scan_positions.*

class ScanPositionsFragment : FragmentBase(), OnScannerRead {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_scan_positions, container, false).apply {
            try {
                ScanWrapper.initScanner(activity.baseContext, (activity as MainActivity).scannerType)
            } catch (e: Exception) {
                exceptionMessage(context.getString(R.string.error_init_scanner) + e.message)
            }
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNewItem.setOnClickListener { navigateTo(NewItemRoute()) }
        tvLokalization.text = activity.baseContext.getString(R.string.location).plus((activity as MainActivity).currentLocation)
        back.setOnClickListener {
            sectionLogo.visibility = View.VISIBLE
            sectionScann.visibility = View.GONE
            it.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        try {
            ScanWrapper.registerScannerListener(this)
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.error_registry_scanner) + e.message)
        }
    }

     override fun onPause() {
        super.onPause()
        try {
            ScanWrapper.unregisterScannerListener()
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.error_unregistry_scanner) + e.message)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        try {
            ScanWrapper.deinitScanner()
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.cant_release_scanner) + e.message)
        }
    }

    override fun onReadData(data: String) {
        tvEAN.setText(data)
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
        val item: Item? = dbContext.items.where(Item_Table.code.eq(codew)).and(Item_Table.oldLocation.eq((activity as MainActivity).currentLocation)).querySingle()
        item?.let {
            sectionLogo.visibility = View.GONE
            sectionScann.visibility = View.VISIBLE
            back.visibility = View.VISIBLE
            sectionSupportCode.visibility.let { if (item.supportCode.trim().isNotEmpty()) View.VISIBLE else View.GONE }
            tvName.setText(it.name)
            tvAmount.setText((++it.endNumber).toString())
            tvLokalization.setText(it.oldLocation)
            it.itemState = activity.getString(R.string.scanner)
            it.save()
        } ?: showNewPositionDialog(tvEAN.text.toString())
    }

    fun showNewPositionDialog(codePos: String) {
        NewPositionDialogFragment({ navigateTo(NewItemRoute(code = codePos, itemState = activity.getString(R.string.scanner))) }).show((activity as MainActivity).fragmentManager, "dialog")
    }
}