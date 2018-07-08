package com.income.icminwentaryzacja.fragments.positions_list.holder

import android.view.View
import android.widget.TextView
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.fragments.positions_list.viewmodel.ItemViewModel

class ItemHolder(view: View): GenericViewHolder<ItemViewModel>(view) {
    override fun bind(itemVM: ItemViewModel) {
        (itemView.findViewById(R.id.tvName) as TextView).setText(itemVM.item.name)
        (itemView.findViewById(R.id.tvAmountPos) as TextView).setText(itemVM.item.startNumber.toString())
//        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}