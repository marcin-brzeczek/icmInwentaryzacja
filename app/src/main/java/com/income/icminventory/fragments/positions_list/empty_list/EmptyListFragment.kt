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
import kotlinx.android.synthetic.main.fragment_list.etSearch
import kotlinx.android.synthetic.main.fragment_list.imgClear
import kotlinx.android.synthetic.main.fragment_list.tvTitle

class EmptyListFragment : FragmentSearch() {

    override fun getFragmenType(): FragmentType = FragmentType.EmptyListFragment

    override fun loadItemViewModels(): MutableList<ViewModel> = dbContext.items.where(Item_Table.oldLocation.eq((activity as MainActivity).currentLocation)).queryList().filter { it.endNumber < 1 }.map { ItemViewModel(it, activity.baseContext) }.toMutableList()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle.text = activity.getString(R.string.entry_list)
        imgClear.setOnClickListener {
            etSearch.text.clear()
            loadAllData(loadItemViewModels())
        }
    }
}