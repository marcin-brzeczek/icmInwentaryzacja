package com.income.icminwentaryzacja.fragments.positions_list.scanned_list

import android.os.Bundle
import android.view.View
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.cache.LocationCache
import com.income.icminwentaryzacja.database.dto.Item_Table
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentSearch
import com.income.icminwentaryzacja.fragments.adapter.IOnReloadAdapterListener
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_list.etSearch
import kotlinx.android.synthetic.main.fragment_list.imgClear
import kotlinx.android.synthetic.main.fragment_list.tvTitle

class ScannedListFragment : FragmentSearch(), IOnReloadAdapterListener {

    override fun loadItemViewModels(): MutableList<ViewModel>  = dbContext.items.where(Item_Table.oldLocation.eq(LocationCache.locationName)).queryList().filter { it.endNumber > 0 }.map { ItemViewModel(it, activity.baseContext) }.toMutableList()

    override fun getFragmenType(): FragmentType  = FragmentType.ScannedListFragment

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle.text = activity.getString(R.string.scanned_list)
        imgClear.setOnClickListener {
            etSearch.text.clear()
            loadAllData(loadItemViewModels()) }
    }
}