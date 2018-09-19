package com.income.icminventory.fragments.information

import android.os.Parcel
import com.income.icminventory.backstack.BaseRoute
import paperparcel.PaperParcel

@PaperParcel
data class InfoFragmentRoute( val tag: String = InfoFragmentRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = InfoFragment()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        PaperParcelInfoFragmentRoute.writeToParcel(this, parcel, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelInfoFragmentRoute.CREATOR
    }
}