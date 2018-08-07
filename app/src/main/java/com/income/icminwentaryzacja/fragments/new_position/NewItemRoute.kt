package com.income.icminwentaryzacja.fragments.new_position

import android.os.Bundle
import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import paperparcel.PaperParcel

const val NEW_ITEM_CODE = "item_code"

@PaperParcel
data class NewItemRoute(val code: String? = null, val tag: String = NewItemRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = NewItemFragment().apply {
        arguments = (arguments ?: Bundle()).apply { putString(NEW_ITEM_CODE, code) }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        PaperParcelNewItemRoute.writeToParcel(this, parcel, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelNewItemRoute.CREATOR
    }
}