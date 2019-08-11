package com.income.icminventory.fragments.location

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminventory.R
import com.income.icminventory.activities.MainActivity
import com.income.icminventory.database.DBContext
import com.income.icminventory.database.dto.Location
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.adapter.ItemAdapter
import com.income.icminventory.fragments.adapter.TypesFactoryImpl
import com.income.icminventory.fragments.adapter.viewmodel.LocationViewModel
import com.income.icminventory.fragments.scan_positions.ScanPositionsRoute
import com.income.icminventory.utilities.fadeIn
import com.income.icminventory.utilities.fadeOut
import com.income.icminventory.utilities.inflate
import kotlinx.android.synthetic.main.fragment_choose_location.*
import javax.inject.Inject

private const val ANIMATED_VIEW_OPACITY = 0.85F

class ChooseLocationFragment : FragmentBase() {

    @Inject
    lateinit var databaseContext: DBContext

    private lateinit var _adapter: ItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_choose_location, container) {
            setActionBar(this@ChooseLocationFragment)
            setHasOptionsMenu(true)
        }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        addNewLocation.setOnClickListener { navigateTo(NewLocationRoute()) }
        scanNewLocation.setOnClickListener {
            (activity as MainActivity).currentLocation =""
            navigateTo(ScanPositionsRoute())
        }

        importLocationFile.setOnClickListener {
            selectLocationsCSVFile()
            addNewLocationMenu.close(false)
            animatedView.alpha = 0F
        }
        setFloatingMenuButtonListener()
    }

    override fun onStart() {
        super.onStart()
        val viewModels = databaseContext.locations.queryList().map { LocationViewModel(Location(it.name), activity.baseContext) }
        rv_locations.layoutManager = LinearLayoutManager(activity.baseContext)
        _adapter = ItemAdapter(viewModels.toMutableList(), TypesFactoryImpl(), this)
        rv_locations.adapter = _adapter
    }

    private fun setFloatingMenuButtonListener() = with(addNewLocationMenu) {
        setOnMenuButtonClickListener {
            if (isOpened) {
                fadeOut(animatedView, (animationDelayPerItem * childCount).toLong())
            } else {
                fadeIn(animatedView, (animationDelayPerItem * childCount).toLong(), ANIMATED_VIEW_OPACITY)
            }
            toggle(true)
        }
    }
}