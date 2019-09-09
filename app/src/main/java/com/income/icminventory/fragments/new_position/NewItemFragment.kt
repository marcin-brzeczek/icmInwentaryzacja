package com.income.icminventory.fragments.new_position

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
import com.income.icminventory.utilities.alsoUnless
import com.income.icminventory.utilities.displayError
import com.income.icminventory.utilities.hideKeyboard
import com.income.icminventory.utilities.toast
import kotlinx.android.synthetic.main.fragment_new_position.btnSave
import kotlinx.android.synthetic.main.fragment_new_position.etAmount
import kotlinx.android.synthetic.main.fragment_new_position.etCode
import kotlinx.android.synthetic.main.fragment_new_position.etName
import kotlinx.android.synthetic.main.fragment_new_position.etSupportCode
import kotlinx.android.synthetic.main.fragment_new_position.imgAddAmount
import kotlinx.android.synthetic.main.fragment_new_position.imgRemoveAmount
import kotlinx.android.synthetic.main.fragment_new_position.tvLocation

class NewItemFragment : FragmentBase(), OnScannerRead {

    var currentAmount: Double = 0.0
    private var amount = ""
    private var itemSupplierId = ""
    private var itemOrderId = ""
    private var itemState = ""
    private var item: Item? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_position, container, false).apply {
            setActionBar(this@NewItemFragment)
            try {
                ScanWrapper.initScanner(activity.baseContext, (activity as MainActivity).scannerType)
            } catch (e: Exception) {
                exceptionMessage(context.getString(R.string.error_init_scanner) + e.message)
            }
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        val itemCode: String? = arguments.getString(NEW_ITEM_CODE)
        itemState = arguments?.getString(NEW_ITEM_STATE) ?: getString(R.string.handle)
        itemSupplierId = arguments?.getString(NEW_ITEM_SUPPLIER_ID) ?: ""
        itemOrderId = arguments?.getString(NEW_ITEM_ORDER_ID) ?: ""

        tvLocation.text = (activity as MainActivity).currentLocation
        etCode.setText(itemCode)

        btnSave.setOnClickListener { saveItem() }
        setHasOptionsMenu(true)

        imgRemoveAmount.setOnClickListener { setAmount();etAmount.setText(if (currentAmount > 0.0) (--currentAmount).toString() + "" else "0.0") }
        imgAddAmount.setOnClickListener { setAmount();etAmount.setText((++currentAmount).toString() + "") }
        etAmount.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                item?.endNumber = (etAmount.text.toString().toDouble())
                item?.itemState = activity.getString(R.string.handle)
                item?.supplierId = itemSupplierId
                item?.orderId = itemOrderId
                item?.user = (activity as MainActivity).currentUser
                item?.save()
                hideKeyboard(etAmount)
                return@OnKeyListener true
            }
            false
        })
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

    private fun setTextIfHasFocus(scannedData: String) {
        listOf(etCode, etSupportCode, etName).forEach {
            if (it.hasFocus()) {
                it.setText(scannedData)
                it.focusSearch(View.FOCUS_DOWN)?.requestFocus()
                return
            }
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
        setTextIfHasFocus(data)
    }

    override fun onReadStatus(text: String) {
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show();
    }

    private fun saveItem() {
        if (!validateInput()) return
        Item(code = etCode.text.toString().trim(),
            supportCode = etSupportCode.text.toString().trim(),
            shortName = "",
            supplierId = itemSupplierId,
            orderId = itemOrderId,
            name = if (etName.text.isBlank()) etCode.text.toString() else etName.text.toString(),
            oldLocation = tvLocation.text.toString(),
            startNumber = 0.0,
            endNumber = etAmount.text.toString().toDouble(),
            itemState = activity.getString(R.string.handle),
            user = (activity as MainActivity).currentUser
        ).insert()
        Toast.makeText(activity.baseContext, getString(R.string.saved), Toast.LENGTH_SHORT).show()
        navigateBack()
    }

    private fun validateInput() = alsoUnless({ etCode.text.trim().isNotEmpty() }) {
        if (etCode.text.isBlank()) etCode.text.clear()
        if (etName.text.isBlank()) etName.text.clear()
        displayError(etCode, etName, context = activity.baseContext)
    }.run {
        val existItem = dbContext.items.where(Item_Table.code.eq(etCode.text.toString())).querySingle()
        existItem?.let {
            toast("Już istnieje pozycja o takim kodzie w bazie")
            false
        } ?: true
    }

    private fun setAmount() {
        amount = if (etAmount.getText().toString() != null && etAmount.getText().toString().length > 1)
            etAmount.getText().toString()
        else
            "1.0"
        currentAmount = java.lang.Double.valueOf(amount)
    }
}