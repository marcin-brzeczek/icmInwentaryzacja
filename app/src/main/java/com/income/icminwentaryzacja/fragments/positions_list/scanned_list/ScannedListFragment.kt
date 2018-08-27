package com.income.icminwentaryzacja.fragments.positions_list.scanned_list

import com.income.icminwentaryzacja.cache.LocationCache
import com.income.icminwentaryzacja.database.dto.Item_Table
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentSearch
import com.income.icminwentaryzacja.fragments.adapter.IOnReloadAdapterListener
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ViewModel

class ScannedListFragment : FragmentSearch(), IOnReloadAdapterListener {

    override fun loadItemViewModels(): MutableList<ViewModel>  = dbContext.items.where(Item_Table.oldLocation.eq(LocationCache.locationName)).queryList().filter { it.endNumber > 0 }.map { ItemViewModel(it, activity.baseContext) }.toMutableList()

    override fun getFragmenType(): FragmentType  = FragmentType.ScannedListFragment
}