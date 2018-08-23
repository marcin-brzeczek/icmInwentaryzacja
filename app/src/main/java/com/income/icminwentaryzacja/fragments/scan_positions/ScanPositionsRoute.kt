package com.income.icminwentaryzacja.fragments.scan_positions

import android.os.Bundle
import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import paperparcel.PaperParcel

const val LOCATION_NAME = "location_name"

@PaperParcel
    data class ScanPositionsRoute(val locationName: String, val tag: String = ScanPositionsRoute::javaClass.name) : BaseRoute() {

        override fun createFragment() = ScanPositionsFragment().apply {
            arguments = (arguments ?: Bundle()).apply {
            putString(LOCATION_NAME, locationName)
        }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            PaperParcelScanPositionsRoute.writeToParcel(this, parcel, flags)
        }

        companion object {
            @JvmField
            val CREATOR = PaperParcelScanPositionsRoute.CREATOR
        }
    }