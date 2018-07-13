package com.income.icminwentaryzacja.fragments.positions_list.empty_list

import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import paperparcel.PaperParcel

@PaperParcel
    data class EmptyListRoute(val tag: String = EmptyListRoute::javaClass.name) : BaseRoute() {

        override fun createFragment() = EmptyListFragment()

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            PaperParcelEmptyListRoute.writeToParcel(this, parcel, flags)
        }

        companion object {
            @JvmField
            val CREATOR = PaperParcelEmptyListRoute.CREATOR
        }
    }

