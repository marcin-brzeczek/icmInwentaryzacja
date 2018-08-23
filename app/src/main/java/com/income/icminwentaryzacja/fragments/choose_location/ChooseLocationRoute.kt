package com.income.icminwentaryzacja.fragments.choose_location

import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.fragments.choose_location.ChooseLocationFragment
import paperparcel.PaperParcel

@PaperParcel
data class ChooseLocationRoute( val tag: String = ChooseLocationRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = ChooseLocationFragment()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        PaperParcelChooseLocationRoute.writeToParcel(this, parcel, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelChooseLocationRoute.CREATOR
    }
}