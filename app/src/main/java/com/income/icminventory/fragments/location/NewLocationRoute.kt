package com.income.icminventory.fragments.location

import android.os.Parcel
import com.income.icminventory.backstack.BaseRoute
import paperparcel.PaperParcel

@PaperParcel
data class NewLocationRoute( val tag: String = NewLocationRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = NewLocationFragment()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        PaperParcelNewLocationRoute.writeToParcel(this, parcel, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelNewLocationRoute.CREATOR
    }
}