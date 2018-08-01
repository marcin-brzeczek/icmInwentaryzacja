package com.income.icminwentaryzacja.fragments.new_position

import android.os.Bundle
import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.database.dto.Item
import paperparcel.PaperParcel

const val NEW_ITEM_KEY = "new_item"

@PaperParcel
data class NewItemRoute(val item: Item? = null, val tag: String = NewItemRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = NewItemFragment().apply {
        arguments = (arguments ?: Bundle()).apply {
            putParcelable(NEW_ITEM_KEY, item)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        PaperParcelNewItemRoute.writeToParcel(this, parcel, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelNewItemRoute.CREATOR
    }
}

