package com.income.icminventory.fragments.positions_list.empty_list

import android.os.Bundle
import android.view.View
import com.income.icminventory.R
import com.income.icminventory.activities.MainActivity
import com.income.icminventory.database.dto.Item_Table
import com.income.icminventory.fragments.FragmentType
import com.income.icminventory.fragments.abstraction.FragmentSearch
import com.income.icminventory.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminventory.fragments.adapter.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class EmptyListFragment : FragmentSearch() {

    override fun getFragmenType(): FragmentType = FragmentType.EmptyListFragment

    override fun loadItemViewModels(): MutableList<ViewModel> = dbContext.items.where(Item_Table.oldLocation.eq((activity as MainActivity).currentLocation)).queryList().filter { it.endNumber < 1 }.map { ItemViewModel(it, activity.baseContext) }.toMutableList()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBar(this@EmptyListFragment)
        tvTitle.text = activity.getString(R.string.entry_list)
        tvLocation.text = activity.getString(R.string.location).plus((activity as MainActivity).currentLocation)

        checkBoxHandle.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked && !checkBoxScanned.isChecked -> filter { vm -> (vm as ItemViewModel).item.user.isBlank() }
                !isChecked && checkBoxScanned.isChecked -> filter { vm -> (vm as ItemViewModel).item.user.isNotBlank() }
                !isChecked && !checkBoxScanned.isChecked -> filter { vm -> false }
                isChecked && checkBoxScanned.isChecked -> filter { vm -> true }
            }
        }

        checkBoxScanned.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked && !checkBoxHandle.isChecked -> filter { vm -> (vm as ItemViewModel).item.user.isNotBlank() }
                !isChecked && checkBoxHandle.isChecked -> filter { vm -> (vm as ItemViewModel).item.user.isBlank() }
                !isChecked && !checkBoxHandle.isChecked -> filter { vm -> false }
                isChecked && checkBoxHandle.isChecked -> filter { vm -> true }
            }
        }

        imgClear.setOnClickListener {
            etSearch.text.clear()
            checkBoxHandle.isChecked = true
            checkBoxScanned.isChecked = true
            filter { vm -> true }
        }
//            loadAllData(loadItemViewModels())
    }
}