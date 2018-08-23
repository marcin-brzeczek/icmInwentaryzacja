package com.income.icminwentaryzacja.fragments.adapter.holder

import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.TextView
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.backstack.BackstackService
import com.income.icminwentaryzacja.cache.LocationCache
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.FragmentType.ChooseLocationFragment
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.LocationViewModel
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsRoute

class LocationHolder(view: View) : GenericViewHolder<LocationViewModel>(view) {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bind(itemVM: LocationViewModel, fragmentType: FragmentType) {

        when (fragmentType) {

            ChooseLocationFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).apply {
                    setText(itemVM.item.name)
                    setOnClickListener {    BackstackService.get(itemView.context).goTo(ScanPositionsRoute())
                        LocationCache.locationName = itemVM.item.name}
                }
            }
        }
    }
}