package com.income.icminwentaryzacja.fragments.positions_list

import android.view.View
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.positions_list.holder.GenericViewHolder

interface ITypesFactory {
    fun type(item: Item): Int
    //    fun type(mouse: Mouse): Int
    fun holder(type: Int, view: View): GenericViewHolder<*>
}