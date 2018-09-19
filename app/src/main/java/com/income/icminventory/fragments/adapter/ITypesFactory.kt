package com.income.icminventory.fragments.adapter

import android.view.View
import com.income.icminventory.database.dto.Item
import com.income.icminventory.database.dto.Location
import com.income.icminventory.fragments.adapter.holder.GenericViewHolder

interface ITypesFactory {
    fun type(item: Item): Int
    fun type(location: Location): Int
    fun holder(type: Int, view: View): GenericViewHolder<*>
}