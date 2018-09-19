package com.income.icminventory.fragments.positions_list.scanned_list

import android.os.Bundle
import android.os.Parcel
import com.income.icminventory.backstack.BaseRoute
import paperparcel.PaperParcel

const val SCANNED_LIST_LOCATION = "scanned_list_location"


@PaperParcel
data class ScannedListRoute(val locationName : String, val tag: String = ScannedListRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = ScannedListFragment().apply {
        arguments = (arguments ?: Bundle()).apply {
            putString(SCANNED_LIST_LOCATION, locationName)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        PaperParcelScannedListRoute.writeToParcel(this, parcel, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelScannedListRoute.CREATOR
    }
}

