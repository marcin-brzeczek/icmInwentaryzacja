package com.income.icminwentaryzacja.fragments.new_position

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.cache.LocationCache.locationName
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.utilities.alsoUnless
import com.income.icminwentaryzacja.utilities.displayError
import com.income.icminwentaryzacja.utilities.inflate
import kotlinx.android.synthetic.main.fragment_new_position.*
import kotlinx.android.synthetic.main.fragment_new_position.view.*

class NewItemFragment : FragmentBase() {
    var currentAmount: Double = 0.0
    private var amount = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_new_position, container) {
                val itemCode: String? = arguments.getString(NEW_ITEM_CODE)

                tvLokalization.setText(locationName)
                etCode.setText(itemCode)

                btnSave.setOnClickListener { saveItem() }
                setHasOptionsMenu(true)

                imgRemoveAmount.setOnClickListener { setAmount();tvAmount.setText(if (currentAmount > 1.0) (--currentAmount).toString() + "" else "1.0") }
                imgAddAmount.setOnClickListener { setAmount();tvAmount.setText((++currentAmount).toString() + "") }
            }


    private fun saveItem() {
        if (!validateInput()) return
        Item(code = etCode.text.toString().trim(),
                supportCode = "",
                shortName = "",
                name = etName.text.toString(),
                oldLocation = tvLokalization.text.toString(),
                startNumber = 0.0,
                endNumber = tvAmount.text.toString().toDouble(),
                itemState = "nowa",
                user = ""
        ).insert()
        Toast.makeText(activity.baseContext, getString(R.string.saved), Toast.LENGTH_SHORT).show()
        navigateBack()
    }

    private fun validateInput() = alsoUnless({ etCode.text.trim().isNotEmpty() && etName.text.trim().isNotEmpty() }) {
        if(etCode.text.isBlank()) etCode.text.clear()
        if(etName.text.isBlank()) etName.text.clear()
        displayError(etCode, etName, context = activity.baseContext)
    }

    private fun setAmount() {
        amount = if (tvAmount.getText().toString() != null && tvAmount.getText().toString().length > 1)
            tvAmount.getText().toString()
        else
            "1.0"
        currentAmount = java.lang.Double.valueOf(amount)
    }
}