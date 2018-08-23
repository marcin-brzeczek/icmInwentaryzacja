package com.income.icminwentaryzacja.fragments.positions_list.empty_list

import android.os.Bundle
import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.fragments.scan_positions.LOCATION_NAME
import paperparcel.PaperParcel

@PaperParcel
    data class EmptyListRoute( val locationName: String? = null, val tag: String = EmptyListRoute::javaClass.name) : BaseRoute() {

        override fun createFragment() = EmptyListFragment().apply {
            arguments = (arguments ?: Bundle()).apply {
                putString(LOCATION_NAME, locationName)
            }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            PaperParcelEmptyListRoute.writeToParcel(this, parcel, flags)
        }

        companion object {
            @JvmField
            val CREATOR = PaperParcelEmptyListRoute.CREATOR
        }
    }

