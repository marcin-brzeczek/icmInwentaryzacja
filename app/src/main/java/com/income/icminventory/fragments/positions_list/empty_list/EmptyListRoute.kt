package com.income.icminventory.fragments.positions_list.empty_list

import android.os.Bundle
import android.os.Parcel
import com.income.icminventory.backstack.BaseRoute
import paperparcel.PaperParcel

const val EMPTY_LIST_LOCATION = "empty_list_location"

@PaperParcel
    data class EmptyListRoute( val locationName: String? = null, val tag: String = EmptyListRoute::javaClass.name) : BaseRoute() {

        override fun createFragment() = EmptyListFragment().apply {
            arguments = (arguments ?: Bundle()).apply {
                putString(EMPTY_LIST_LOCATION, locationName)
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

