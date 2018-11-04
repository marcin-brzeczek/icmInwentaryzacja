package com.income.icminventory.fragments.positions_list.scanned_list

import android.os.Bundle
import android.view.View
import com.income.icminventory.R
import com.income.icminventory.activities.MainActivity
import com.income.icminventory.database.dto.Item_Table
import com.income.icminventory.fragments.FragmentType
import com.income.icminventory.fragments.abstraction.FragmentSearch
import com.income.icminventory.fragments.adapter.IOnReloadAdapterListener
import com.income.icminventory.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminventory.fragments.adapter.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_list.etSearch
import kotlinx.android.synthetic.main.fragment_list.imgClear
import kotlinx.android.synthetic.main.fragment_list.tvLocation
import kotlinx.android.synthetic.main.fragment_list.tvTitle

class ScannedListFragment : FragmentSearch(), IOnReloadAdapterListener {

    override fun loadItemViewModels(): MutableList<ViewModel> = dbContext.items.where(Item_Table.oldLocation.eq((activity as MainActivity).currentLocation)).queryList().filter { it.endNumber > 0 }.map { ItemViewModel(it, activity.baseContext) }.toMutableList()

    override fun getFragmenType(): FragmentType = FragmentType.ScannedListFragment

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBar(this@ScannedListFragment)
        tvTitle.text = activity.getString(R.string.scanned_list)
        tvLocation.text = activity.getString(R.string.location).plus((activity as MainActivity).currentLocation)
        imgClear.setOnClickListener {
            etSearch.text.clear()
            loadAllData(loadItemViewModels())
        }
    }
}