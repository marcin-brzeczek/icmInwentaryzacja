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
import com.income.icminventory.fragments.location.NewLocationRoute
import com.income.icminventory.fragments.new_position.NewItemRoute
import com.income.icminventory.utilities.hideKeyboard
import com.income.icminventory.utilities.toast
import com.income.icminventory.views.NewPositionDialogFragment
import com.income.icminventory.views.YesOrNotDialogFragment
import kotlinx.android.synthetic.main.fragment_scan_positions.*

class ScanPositionsFragment : FragmentBase(), OnScannerRead {

    var currentAmount: Double = 0.0
    var scanningLocalization = false
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
        setLocalizationTitle()
        setListeners()
    }

    private fun setListeners() {
        addNewItem.setOnClickListener { navigateTo(NewItemRoute()) }
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

    private fun setLocalizationTitle() {
        val existLocation = (activity as MainActivity).currentLocation
        scanningLocalization = existLocation.isEmpty()

        if (scanningLocalization) {
            addNewItem.visibility = View.GONE
            tvLokalization.text = getString(R.string.scan_localization)
        } else
            tvLokalization.text = activity.baseContext.getString(R.string.location).plus(existLocation)
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

        if (scanningLocalization) {
            getLocalizationByCode(finishData)
        } else {
            getPositionByCode(finishData)
        }
    }

    private fun getLocalizationByCode(localizationName: String) {
        (activity as MainActivity).scannedLocation = localizationName
        navigateTo(NewLocationRoute())
    }

    override fun onReadStatus(text: String) {
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show()
    }

    private fun getPositionByCode(scannedCode: String) {
        /*regionFor es system k company */

        var code = ""
        var supplierId = ""
        var orderId = ""

        if (scannedCode.startsWith("#")) {
            toast("Błąd odczytu: kod nie może zaczynać się od znaku '#'", Toast.LENGTH_LONG)
            return
        }

        val data = scannedCode.split("#")
        if (data.size >= 3) {
            code = data.get(0)
            supplierId = data.get(1)
            orderId = data.get(2)
        } else {
            return
        }
        /*endregion*/

        toast("code: $code supplier: $supplierId order: $orderId")

        item = dbContext.items.where(
            Item_Table.code.eq(code))
            .or(Item_Table.supportCode.eq(code))
            .or(Item_Table.code.eq(scannedCode))
            .and(Item_Table.supplierId.eq(supplierId))
            .and(Item_Table.orderId.eq(orderId))
            .and(Item_Table.oldLocation.eq((activity as MainActivity).currentLocation)).querySingle()

        item?.let { createOrUpdateItem(it, code, supplierId, orderId) }
            ?: getItemWihoutLocalization(scannedCode)?.let { showMoveItemToLocalizationDialog(it, code, supplierId, orderId) }
            ?: showNewPositionDialog(code, supplierId, orderId)
    }

    private fun getItemWihoutLocalization(code: String): Item? = dbContext.items.where(Item_Table.code.eq(code)).or(Item_Table.supportCode.eq(code)).querySingle()

    private fun createOrUpdateItem(item: Item, correctedCode: String, scannedSupplierId: String, scannedOrderId: String) = with(item) {
        this.oldLocation = (activity as MainActivity).currentLocation
        this.supplierId = scannedSupplierId
        this.orderId = scannedOrderId
        sectionLogo.visibility = View.GONE
        sectionScann.visibility = View.VISIBLE
        back.visibility = View.VISIBLE
        sectionSupportCode.visibility.let { if (supportCode.trim().isNotEmpty()) View.VISIBLE else View.GONE }
        tvName.setText(name)
        etAmount.setText((++endNumber).toString())
        tvCode.setText(correctedCode)
        tvSupportCode.setText(supportCode)
        tvLokalization.setText(oldLocation)
        itemState = let { if (it.equals(activity.getString(R.string.handle))) activity.getString(R.string.handle) else activity.getString(R.string.scanner) }
        this.save()
    }

    fun showMoveItemToLocalizationDialog(item: Item, code: String, supplierId: String, orderId: String) {
        YesOrNotDialogFragment(blockYesClick =
        {
            createOrUpdateItem(item, code, supplierId, orderId)
        }, blockNoClick = {}
            , text = getString(R.string.assing_to_localization))
            .show((activity as MainActivity).fragmentManager, "dialog")
    }

    fun showNewPositionDialog(codePos: String, supplierId: String, orderId: String) {
        NewPositionDialogFragment {
            navigateTo(
                NewItemRoute(
                    code = codePos,
                    supplierId = supplierId,
                    orderId = orderId,
                    itemState = activity.getString(R.string.scanner))
            )
        }
            .show((activity as MainActivity).fragmentManager, "dialog")
    }
}