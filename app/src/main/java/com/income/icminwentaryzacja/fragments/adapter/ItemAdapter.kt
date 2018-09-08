package com.income.icminwentaryzacja.fragments.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.adapter.holder.GenericViewHolder
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ViewModel


class ItemAdapter(var items: MutableList<ViewModel>, val typeFactory: ITypesFactory, val fragmentBase: FragmentBase) : RecyclerView.Adapter<GenericViewHolder<ViewModel>>() {

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: GenericViewHolder<ViewModel>?, position: Int) {
        holder?.bind(items[position], fragmentBase)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GenericViewHolder<ViewModel> {
        if (parent != null) {
            val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
            return typeFactory.holder(viewType, view) as GenericViewHolder<ViewModel>
        }
        throw RuntimeException("Parent is null")
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(typeFactory)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
    }

    fun setListItem(items: MutableList<ViewModel>) {
        this.items = items
        notifyDataSetChanged()
    }
}