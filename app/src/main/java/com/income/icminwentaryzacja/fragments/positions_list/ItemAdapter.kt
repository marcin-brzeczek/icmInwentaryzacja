package com.income.icminwentaryzacja.fragments.positions_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.income.icminwentaryzacja.fragments.positions_list.holder.GenericViewHolder
import com.income.icminwentaryzacja.fragments.positions_list.viewmodel.ViewModel


class ItemAdapter(val items: List<ViewModel>,
              val typeFactory: ITypesFactory)
    : RecyclerView.Adapter<GenericViewHolder<ViewModel>>() {

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: GenericViewHolder<ViewModel>?, position: Int) {
        holder?.bind(items[position])
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
}