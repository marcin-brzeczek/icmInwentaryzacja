package com.income.icminwentaryzacja.fragments.positions_list.scanned_list

import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import paperparcel.PaperParcel

@PaperParcel
    data class ScannedListRoute(val tag: String = ScannedListRoute::javaClass.name) : BaseRoute() {

        override fun createFragment() = ScannedListFragment()

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            PaperParcelScannedListRoute.writeToParcel(this, parcel, flags)
        }

        companion object {
            @JvmField
            val CREATOR = PaperParcelScannedListRoute.CREATOR
        }
    }

