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
import com.income.icminventory.database.dto.Location_Table
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
        scanLocation.setOnClickListener {
            (activity as MainActivity).currentLocation = ""
            setLocalizationTitle()
        }
        back.setOnClickListener {
            sectionLogo.visibility = View.VISIBLE
            sectionScann.visibility = View.GONE
            it.visibility = View.GONE
            addNewItem.visibility = View.VISIBLE
            scanLocation.visibility = View.VISIBLE
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
            tvLokalization.text = getString(R.string.scan_localization)
            addNewItem.visibility = View.GONE
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

        setViewsForScanningLocation()

        if (scanningLocalization) {
            getLocalizationByCode(finishData)
        } else {
            getPositionByCode(finishData)
        }
    }

    private fun setViewsForScanningLocation() {
        sectionLogo.visibility = if (scanningLocalization) View.VISIBLE else View.GONE
        scanLocation.visibility = if (scanningLocalization) View.VISIBLE else View.GONE
        sectionScann.visibility = if (scanningLocalization) View.GONE else View.VISIBLE
        back.visibility = if (scanningLocalization) View.GONE else View.VISIBLE
    }

    private fun showViewsForScanningLPosition() {
        sectionLogo.visibility = View.VISIBLE
        scanLocation.visibility = View.VISIBLE
        sectionScann.visibility = View.GONE
        addNewItem.visibility = View.VISIBLE
        back.visibility = View.GONE
    }

    private fun getLocalizationByCode(localizationName: String) {
        (activity as MainActivity).scannedLocation = localizationName

        val location = dbContext.locations.where(Location_Table.name.eq(localizationName)).querySingle()
        if (location == null) {
            showNewLocationDialog()
        } else {
            showViewsForScanningLPosition()
            scanningLocalization = false
            (activity as MainActivity).currentLocation = location.name
            tvLokalization.setText(location.name)
        }
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

        if (!scannedCode.contains("#")) {
            code = scannedCode
            supplierId = " "
            orderId = " "
        } else {
            val data = scannedCode.split("#")
            if (data.isNotEmpty()) {
                code = data.get(0)
                supplierId = data.getOrNull(1) ?: " "
                orderId = data.getOrNull(2) ?: " "
            } else {
                return
            }
        }

        /*endregion*/

        addNewItem.visibility = View.GONE

        item = dbContext.items.where(
            Item_Table.code.eq(code))
            .and(Item_Table.supplierId.eq(supplierId))
            .and(Item_Table.orderId.eq(orderId))
            .and(Item_Table.oldLocation.eq((activity as MainActivity).currentLocation)).querySingle()

        item?.let { createOrUpdateItem(it, code, supplierId, orderId) }
            ?: getItemWihoutLocalization(code)?.let { addNewItem(it, code, supplierId, orderId) }
            ?: showNewPositionDialog(code, supplierId, orderId).also {  showViewsForScanningLPosition() }
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

    fun addNewItem(item: Item, code: String, supplierId: String, orderId: String) {
        val newItem = item.copy(
            code = code,
            id = item.id + 1,
            supplierId = supplierId,
            orderId = orderId,
            endNumber = 1.0,
            oldLocation = (activity as MainActivity).currentLocation
        )
        tvName.setText(newItem.name)
        tvCode.setText(newItem.code)
        etAmount.setText(newItem.endNumber.toString())
        newItem.insert()
    }

    fun showNewLocationDialog() {
        YesOrNotDialogFragment(blockYesClick =
        {
            navigateTo(NewLocationRoute())
        }, blockNoClick = {}
            , text = getString(R.string.add_new_location))
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