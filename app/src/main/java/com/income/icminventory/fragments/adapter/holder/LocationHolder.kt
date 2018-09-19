package com.income.icminventory.fragments.adapter.holder

import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.TextView
import com.income.icminventory.R
import com.income.icminventory.activities.MainActivity
import com.income.icminventory.backstack.BackstackService
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.adapter.viewmodel.LocationViewModel
import com.income.icminventory.fragments.location.ChooseLocationFragment
import com.income.icminventory.fragments.scan_positions.ScanPositionsRoute

class LocationHolder(view: View) : GenericViewHolder<LocationViewModel>(view) {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bind(itemVM: LocationViewModel, fragment: FragmentBase) {

        when (fragment) {

            is ChooseLocationFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).apply {
                    setText(itemVM.item.name)
                    setOnClickListener {
                        (fragment.activity as MainActivity).currentLocation = itemVM.item.name
                        BackstackService.get(itemView.context).goTo(ScanPositionsRoute())
                    }
                }
            }
        }
    }
}