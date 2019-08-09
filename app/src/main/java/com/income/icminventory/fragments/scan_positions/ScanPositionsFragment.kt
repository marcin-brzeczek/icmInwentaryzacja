package com.income.icminventory.fragments.scan_positions

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.income.icminventory.R
import com.income.icminventory.activities.MainActivity
import com.income.icminventory.database.dto.Item
import com.income.icminventory.database.dto.Item_Table
import com.income.icminventory.emkd_scan.OnScannerRead
import com.income.icminventory.emkd_scan.ScanWrapper
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.new_position.NewItemRoute
import com.income.icminventory.utilities.hideKeyboard
import com.income.icminventory.utilities.toast
import com.income.icminventory.views.NewPositionDialogFragment
import kotlinx.android.synthetic.main.fragment_scan_positions.*

class ScanPositionsFragment : FragmentBase(), OnScannerRead {

    var currentAmount: Double = 0.0
    private var amount = ""
    private var item: Item? = null

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
        setActionBar(this@ScanPositionsFragment)
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        addNewItem.setOnClickListener { navigateTo(NewItemRoute()) }
        tvLokalization.text = activity.baseContext.getString(R.string.location).plus((activity as MainActivity).currentLocation)
        back.setOnClickListener {
            sectionLogo.visibility = View.VISIBLE
            sectionScann.visibility = View.GONE
            it.visibility = View.GONE
            item?.endNumber = (etAmount.text.toString().toDouble())
            item?.save()

        }
        imgRemoveAmount.setOnClickListener { setAmount();etAmount.setText(if (currentAmount > 1.0) (--currentAmount).toString() + "" else "1.0") }
        imgAddAmount.setOnClickListener { setAmount();etAmount.setText((++currentAmount).toString() + "") }
        etAmount.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                item?.endNumber = (etAmount.text.toString().toDouble())
                item?.itemState = activity.getString(R.string.handle)
                item?.save()
                hideKeyboard(etAmount)
                return@OnKeyListener true
            }
            false
        })
    }


    private fun setAmount() {
        amount = if (etAmount.getText().toString() != null && etAmount.getText().toString().length > 1)
            etAmount.getText().toString()
        else
            "1.0"
        currentAmount = java.lang.Double.valueOf(amount)
    }

    override fun onStart() {
        super.onStart()
        ScanWrapper.registerBarcodeListener(this)
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
        val enterSuffix = "\n"
        val finishData = if (data.contains(enterSuffix)) data.removeSuffix(enterSuffix) else data
        tvCode.setText(data)
        getPositionByCode(finishData)
    }

    override fun onReadStatus(text: String) {
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show();
    }

    private fun getPositionByCode(scannedCode: String) {
        /*Code */
        val data = scannedCode.split("#")
        val code = data.get(1)
        val supplierId = data.get(2)
        val orderId = data.get(3)

        toast("code: $code supplier: $supplierId order: $orderId")

        item = dbContext.items.where(Item_Table.code.eq(code)).or(Item_Table.supportCode.eq(code)).and(Item_Table.oldLocation.eq((activity as MainActivity).currentLocation)).querySingle()
        item?.let {
            sectionLogo.visibility = View.GONE
            sectionScann.visibility = View.VISIBLE
            back.visibility = View.VISIBLE
            sectionSupportCode.visibility.let { if (item?.supportCode!!.trim().isNotEmpty()) View.VISIBLE else View.GONE }
            tvName.setText(it.name)
            etAmount.setText((++it.endNumber).toString())
            tvCode.setText(it.code)
            tvSupportCode.setText(it.supportCode)
            tvLokalization.setText(it.oldLocation)
            it.itemState = let { if (it.equals(activity.getString(R.string.handle))) activity.getString(R.string.handle) else activity.getString(R.string.scanner) }
            it.save()
//        } ?: showNewPositionDialog(tvCode.text.toString())
        } ?: showNewPositionDialog(code)
    }

    fun showNewPositionDialog(codePos: String) {
        NewPositionDialogFragment({ navigateTo(NewItemRoute(code = codePos, itemState = activity.getString(R.string.scanner))) }).show((activity as MainActivity).fragmentManager, "dialog")
    }
}