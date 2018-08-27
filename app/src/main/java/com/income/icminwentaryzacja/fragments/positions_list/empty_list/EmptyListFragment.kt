package com.income.icminwentaryzacja.fragments.positions_list.empty_list

import com.income.icminwentaryzacja.cache.LocationCache
import com.income.icminwentaryzacja.database.dto.Item_Table
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentSearch
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ViewModel

class EmptyListFragment : FragmentSearch() {

    override fun getFragmenType(): FragmentType = FragmentType.EmptyListFragment

    override fun loadItemViewModels(): MutableList<ViewModel> = dbContext.items.where(Item_Table.oldLocation.eq(LocationCache.locationName)).queryList().map { ItemViewModel(it, activity.baseContext) }.toMutableList()
}