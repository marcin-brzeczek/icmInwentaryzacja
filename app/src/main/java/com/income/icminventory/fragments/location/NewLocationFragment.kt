package com.income.icminventory.fragments.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.income.icminventory.R
import com.income.icminventory.database.dto.Location
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.utilities.toast
import com.income.icminventory.utilities.alsoUnless
import com.income.icminventory.utilities.displayError
import com.income.icminventory.utilities.inflate
import kotlinx.android.synthetic.main.fragment_new_location.view.*
import kotlinx.android.synthetic.main.fragment_new_location.*

class NewLocationFragment : FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_new_location, container) {
                setHasOptionsMenu(true)
                btnSave.setOnClickListener { saveLocation() }
                etName.setOnEditorActionListener { textView, action, event ->
                    var handled = false
                    if (action == EditorInfo.IME_ACTION_DONE) {
                        saveLocation()
                        handled = true
                    }
                    handled
                }
            }

    private fun saveLocation() {
        if (!validateInput()) return
        if(dbContext.locations.queryList().map { it.name }.contains(etName.text.toString())){
            toast(getString(R.string.location_already_exists))
            return
        }
        Location(name = etName.text.toString().trim()).insert()
        toast(getString(R.string.saved))
        navigateBack()
    }

    private fun validateInput() = alsoUnless({ etName.text.trim().isNotEmpty() }) {
        if (etName.text.isBlank()) etName.text.clear()
        displayError(etName, context = activity.baseContext)
    }
}