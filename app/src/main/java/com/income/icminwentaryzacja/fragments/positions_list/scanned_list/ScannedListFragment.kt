package com.income.icminwentaryzacja.fragments.positions_list.scanned_list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.cache.LocationCache.locationName
import com.income.icminwentaryzacja.database.DBContext
import com.income.icminwentaryzacja.database.dto.Item_Table
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.adapter.IOnReloadAdapterListener
import com.income.icminwentaryzacja.fragments.adapter.TypesFactoryImpl
import com.income.icminwentaryzacja.fragments.adapter.ItemAdapter
import com.income.icminwentaryzacja.fragments.adapter.ItemSwipeHelper
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_empty_list.rv_items
import kotlinx.android.synthetic.main.fragment_scan_list.*
import javax.inject.Inject

class ScannedListFragment : FragmentBase(), IOnReloadAdapterListener {

    @Inject
    lateinit var databaseContext: DBContext

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_scan_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        loadAdapter()
    }

    override fun reload() {
        loadAdapter()
    }

    fun loadAdapter() {
        rv_items.layoutManager = LinearLayoutManager(activity.baseContext)
        val itemAdapter = ItemAdapter(databaseContext.items.where(Item_Table.oldLocation.eq(locationName)).queryList().filter { it.endNumber > 0 }.map { ItemViewModel(it, activity.baseContext) }.toMutableList(), TypesFactoryImpl(), FragmentType.ScannedListFragment)
        rv_items.adapter = itemAdapter
        val itemTouchHelper = ItemTouchHelper(ItemSwipeHelper(itemAdapter, activity, this))
        itemTouchHelper.attachToRecyclerView(rv_items)
        tvSumScannedItems.text = databaseContext.items.where(Item_Table.oldLocation.eq(locationName)).queryList().filter { it.endNumber > 0 }.sumByDouble { item -> item.endNumber }.toString()
        itemAdapter.notifyDataSetChanged()
    }
}