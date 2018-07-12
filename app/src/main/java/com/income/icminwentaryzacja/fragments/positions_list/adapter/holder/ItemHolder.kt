package com.income.icminwentaryzacja.fragments.positions_list.adapter.holder

import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.TextView
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.fragments.FragmentType
import com.income.icminwentaryzacja.fragments.FragmentType.EmptyListFragment
import com.income.icminwentaryzacja.fragments.FragmentType.ScannedListFragment
import com.income.icminwentaryzacja.fragments.positions_list.adapter.viewmodel.ItemViewModel
import android.widget.RelativeLayout
import com.income.icminwentaryzacja.fragments.positions_list.adapter.ItemStatus


class ItemHolder(view: View) : GenericViewHolder<ItemViewModel>(view) {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bind(itemVM: ItemViewModel, fragmentType: FragmentType) {

        when (fragmentType) {

            EmptyListFragment -> {

                (itemView.findViewById(R.id.tvName) as TextView).setText(itemVM.item.name)
                (itemView.findViewById(R.id.tvAmountPos) as TextView).setText(itemVM.item.startNumber.toString())
            }

            ScannedListFragment -> {

                val background = (itemView.findViewById(R.id.layoutSheetsItems) as RelativeLayout)
                (itemView.findViewById(R.id.tvName) as TextView).setText(itemVM.item.name)
                (itemView.findViewById(R.id.tvAmountPos) as TextView).setText(itemVM.item.endNumber.toString())

                when (itemVM.getStatus()) {
                    ItemStatus.Brak-> background.background = itemVM.context.getDrawable(R.drawable.background_red)
                    ItemStatus.Nadwyzka-> background.background = itemVM.context.getDrawable(R.drawable.background_blue)
                    ItemStatus.Zgodny-> background.background = itemVM.context.getDrawable(R.drawable.background_teal)
                }
            }
        }
    }
}