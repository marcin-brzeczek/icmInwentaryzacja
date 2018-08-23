package com.income.icminwentaryzacja.fragments.positions_list.scanned_list

import android.os.Bundle
import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.fragments.scan_positions.LOCATION_NAME
import paperparcel.PaperParcel

@PaperParcel
data class ScannedListRoute(val locationName : String, val tag: String = ScannedListRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = ScannedListFragment().apply {
        arguments = (arguments ?: Bundle()).apply {
            putString(LOCATION_NAME, locationName)
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

