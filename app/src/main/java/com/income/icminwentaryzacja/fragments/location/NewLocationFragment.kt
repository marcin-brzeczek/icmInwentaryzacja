package com.income.icminwentaryzacja.fragments.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.dto.Location
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.abstraction.toast
import com.income.icminwentaryzacja.utilities.alsoUnless
import com.income.icminwentaryzacja.utilities.displayError
import com.income.icminwentaryzacja.utilities.inflate
import kotlinx.android.synthetic.main.fragment_new_location.view.*
import kotlinx.android.synthetic.main.fragment_new_location.*

class NewLocationFragment : FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_new_location, container) {
                setHasOptionsMenu(true)
                btnSave.setOnClickListener { saveLocation() }
            }

    private fun saveLocation() {
        if (!validateInput()) return
        Location(name = etName.text.toString().trim()).insert()
        toast(getString(R.string.saved))
        navigateBack()
    }

    private fun validateInput() = alsoUnless({etName.text.trim().isNotEmpty() }) {
        if (etName.text.isBlank()) etName.text.clear()
        displayError(etName, context = activity.baseContext)
    }
}