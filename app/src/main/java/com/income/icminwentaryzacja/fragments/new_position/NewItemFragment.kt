package com.income.icminwentaryzacja.fragments.new_position

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.scan_positions.LOCATION_NAME
import com.income.icminwentaryzacja.utilities.alsoUnless
import com.income.icminwentaryzacja.utilities.displayError
import com.income.icminwentaryzacja.utilities.inflate
import kotlinx.android.synthetic.main.fragment_new_position.*
import kotlinx.android.synthetic.main.fragment_new_position.view.*

class NewItemFragment : FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_new_position, container) {
                val itemCode: String? = arguments.getString(NEW_ITEM_CODE)

                etCode.setText(itemCode)
                btnSave.setOnClickListener { saveItem() }
                setHasOptionsMenu(true)
            }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val locationName = arguments.getString(LOCATION_NAME)
        tvLokalization.setText(locationName)
    }

    private fun saveItem() {
        if (!validateInput()) return
        Item(code = etCode.text.toString().trim(),
                supportCode = "",
                shortName = "",
                name = etName.text.toString(),
                oldLocation = tvLokalization.text.toString(),
                startNumber = 0.0,
                endNumber = 0.0,
                itemState = "nowa",
                user = ""
        ).insert()
        Toast.makeText(activity.baseContext, "Zapisano", Toast.LENGTH_SHORT).show()
        navigateBack()
    }

    private fun validateInput() = alsoUnless({ etCode.text.trim().isNotEmpty() && etName.text.trim().isNotEmpty() }) {
        etCode.text.clear()
        etCode.text.clear()
        displayError(etCode, etName)
    }
}