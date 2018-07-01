package com.income.icminwentaryzacja.fragments.positions_list

import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import paperparcel.PaperParcel


@PaperParcel
    data class ListRoute(val tag: String = ListRoute::javaClass.name) : BaseRoute() {

    @field:Transient
    override val isBottomNavigationVisible = false

        override fun createFragment() = ListFragment()

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            PaperParcelListRoute.writeToParcel(this, parcel, flags)
        }

        companion object {
            @JvmField
            val CREATOR = PaperParcelListRoute.CREATOR
        }
    }

