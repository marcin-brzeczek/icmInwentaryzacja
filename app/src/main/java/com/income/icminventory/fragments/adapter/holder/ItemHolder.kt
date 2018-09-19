package com.income.icminventory.fragments.adapter.holder

import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.income.icminventory.R
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.adapter.ItemStatus
import com.income.icminventory.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminventory.fragments.positions_list.empty_list.EmptyListFragment
import com.income.icminventory.fragments.positions_list.scanned_list.ScannedListFragment

class ItemHolder(view: View) : GenericViewHolder<ItemViewModel>(view) {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bind(itemVM: ItemViewModel, fragmentBase: FragmentBase) {

        when (fragmentBase) {

            is EmptyListFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).text = itemVM.item.name
                (itemView.findViewById(R.id.tvCode) as TextView).text = itemVM.item.code
                (itemView.findViewById(R.id.tvAmountPos) as TextView).text = itemVM.item.startNumber.toString()
            }

            is ScannedListFragment-> {
                (itemView.findViewById(R.id.tvName) as TextView).text = itemVM.item.name
                (itemView.findViewById(R.id.tvCode) as TextView).text = itemVM.item.code
                val tvAmount = (itemView.findViewById(R.id.tvAmountPos) as TextView)
                val imgState = (itemView.findViewById(R.id.imgState) as ImageView)
                imgState.visibility = View.VISIBLE

                val isHandleAdded = itemVM.item.itemState == itemView.context.resources.getString(R.string.handle)
                if (isHandleAdded)
                    imgState.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.handle))
                else
                    imgState.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.barcode))

                tvAmount.text = itemVM.item.endNumber.toString()

                when (itemVM.getStatus()) {
                    ItemStatus.Brak -> tvAmount.setTextColor(itemVM.context.getColor(R.color.red200))
                    ItemStatus.Nadwyzka -> tvAmount.setTextColor(itemVM.context.getColor(R.color.blue400))
                    ItemStatus.Zgodny -> tvAmount.setTextColor(itemVM.context.getColor(R.color.teal400))
                }
            }
        }
    }
}