package com.income.icminwentaryzacja.fragments.adapter.holder

import android.annotation.TargetApi
import android.os.Build
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.fragments.FragmentType
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.TextView
import com.income.icminwentaryzacja.fragments.FragmentType.EmptyListFragment
import com.income.icminwentaryzacja.fragments.FragmentType.ScannedListFragment
import com.income.icminwentaryzacja.fragments.adapter.ItemStatus
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ItemViewModel

class ItemHolder(view: View) : GenericViewHolder<ItemViewModel>(view) {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bind(itemVM: ItemViewModel, fragmentType: FragmentType) {

        when (fragmentType) {

            EmptyListFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).setText(itemVM.item.name)
                (itemView.findViewById(R.id.tvAmountPos) as TextView).setText(itemVM.item.startNumber.toString())
            }

            ScannedListFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).setText(itemVM.item.name)
                val tvAmount = (itemView.findViewById(R.id.tvAmountPos) as TextView)
                tvAmount.setText(itemVM.item.endNumber.toString())

                when (itemVM.getStatus()) {
                    ItemStatus.Brak -> tvAmount.setTextColor(itemVM.context.getColor(R.color.red200))
                    ItemStatus.Nadwyzka -> tvAmount.setTextColor(itemVM.context.getColor(R.color.blue400))
                    ItemStatus.Zgodny -> tvAmount.setTextColor(itemVM.context.getColor(R.color.teal400))
                }
            }
        }
    }
}