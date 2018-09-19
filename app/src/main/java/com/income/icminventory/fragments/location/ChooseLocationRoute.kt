package com.income.icminventory.fragments.location

import android.os.Parcel
import com.income.icminventory.backstack.BaseRoute
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