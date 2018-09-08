package com.income.icminwentaryzacja.fragments.adapter.holder

import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.TextView
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.backstack.BackstackService
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.LocationViewModel
import com.income.icminwentaryzacja.fragments.location.ChooseLocationFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsRoute

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