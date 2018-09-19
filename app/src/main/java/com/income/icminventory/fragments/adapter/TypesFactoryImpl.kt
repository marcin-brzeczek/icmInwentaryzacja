package com.income.icminventory.fragments.adapter

import android.view.View
import com.income.icminventory.R
import com.income.icminventory.database.dto.Item
import com.income.icminventory.database.dto.Location
import com.income.icminventory.fragments.adapter.holder.GenericViewHolder
import com.income.icminventory.fragments.adapter.holder.ItemHolder
import com.income.icminventory.fragments.adapter.holder.LocationHolder

class TypesFactoryImpl : ITypesFactory {

    override fun type(location: Location): Int = R.layout.location_row
    override fun type(item: Item) = R.layout.item_row

    override fun holder(type: Int, view: View): GenericViewHolder<*> {
        return when (type) {
            R.layout.item_row -> ItemHolder(view)
            R.layout.location_row -> LocationHolder(view)
            else -> throw RuntimeException("Illegal view type")
        }
    }
}