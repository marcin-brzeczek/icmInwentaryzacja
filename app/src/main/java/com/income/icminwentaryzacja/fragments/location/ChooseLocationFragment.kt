package com.income.icminwentaryzacja.fragments.location

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.DBContext
import com.income.icminwentaryzacja.database.dto.Location
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.adapter.ItemAdapter
import com.income.icminwentaryzacja.fragments.adapter.TypesFactoryImpl
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.LocationViewModel
import com.income.icminwentaryzacja.utilities.inflate
import kotlinx.android.synthetic.main.fragment_choose_location.*
import kotlinx.android.synthetic.main.fragment_choose_location.view.*
import javax.inject.Inject

class ChooseLocationFragment : FragmentBase() {

    @Inject
    lateinit var databaseContext: DBContext

    private lateinit var _adapter: ItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_choose_location, container) {
                setHasOptionsMenu(true)
                addNewLocation.setOnClickListener { navigateTo(NewLocationRoute()) }
            }

    override fun onStart() {
        super.onStart()
        val viewModels = databaseContext.locations.queryList().map { LocationViewModel(Location(it.name), activity.baseContext) }
        rv_locations.layoutManager = LinearLayoutManager(activity.baseContext)
        _adapter = ItemAdapter(viewModels.toMutableList(), TypesFactoryImpl(), this)
        rv_locations.adapter = _adapter
    }
}