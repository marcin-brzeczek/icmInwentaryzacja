package com.income.icminwentaryzacja.fragments.positions_list.empty_list

import android.os.Bundle
import android.view.View
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.cache.LocationCache
import com.income.icminwentaryzacja.database.dto.Item_Table
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentSearch
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_list.etSearch
import kotlinx.android.synthetic.main.fragment_list.imgClear
import kotlinx.android.synthetic.main.fragment_list.tvTitle

class EmptyListFragment : FragmentSearch() {

    override fun getFragmenType(): FragmentType = FragmentType.EmptyListFragment

    override fun loadItemViewModels(): MutableList<ViewModel> = dbContext.items.where(Item_Table.oldLocation.eq(LocationCache.locationName)).queryList().map { ItemViewModel(it, activity.baseContext) }.toMutableList()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle.text = activity.getString(R.string.entry_list)
        imgClear.setOnClickListener {
            etSearch.text.clear()
            loadAllData(loadItemViewModels())
        }
    }
}