package com.income.icminventory.fragments.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.income.icminventory.fragments.abstraction.FragmentBase

abstract class GenericViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T, fragmentBase: FragmentBase)
}