package com.income.icminwentaryzacja.fragments.positions_list.holder

import android.view.View
import android.widget.TextView
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.FragmentType.EmptyListFragment
import com.income.icminwentaryzacja.fragments.FragmentType.ScannedListFragment
import com.income.icminwentaryzacja.fragments.positions_list.viewmodel.ItemViewModel

class ItemHolder(view: View) : GenericViewHolder<ItemViewModel>(view) {
    override fun bind(itemVM: ItemViewModel, fragmentType: FragmentType) {

        when (fragmentType) {

            EmptyListFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).setText(itemVM.item.name)
                (itemView.findViewById(R.id.tvAmountPos) as TextView).setText(itemVM.item.startNumber.toString())
            }

            ScannedListFragment -> {
                /*TODO dla listy zeskanowanych pozycji */
            }
        }
    }
}