package com.income.icminwentaryzacja.fragments.positions_list.adapter

import android.view.View
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.positions_list.adapter.ITypesFactory
import com.income.icminwentaryzacja.fragments.positions_list.adapter.holder.GenericViewHolder
import com.income.icminwentaryzacja.fragments.positions_list.adapter.holder.ItemHolder

class TypesFactoryImpl : ITypesFactory {

    override fun type(item: Item) = R.layout.item

//    override fun type(mouse: Mouse) = R.layout.v_item_mouse

    override fun holder(type: Int, view: View): GenericViewHolder<*> {
        return when(type) {
            R.layout.item -> ItemHolder(view)
//            R.layout.v_item_mouse -> MouseHolder(view)
            else -> throw RuntimeException("Illegal view type")
        }
    }
}