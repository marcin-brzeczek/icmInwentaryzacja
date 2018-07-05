package com.income.icminwentaryzacja.fragments.positions_list.holder

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class GenericViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
}