package com.income.icminventory.fragments.adapter.holder

import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.income.icminventory.R
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.adapter.ItemStatus
import com.income.icminventory.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminventory.fragments.positions_list.empty_list.EmptyListFragment
import com.income.icminventory.fragments.positions_list.scanned_list.ScannedListFragment
import org.jetbrains.anko.find

class ItemHolder(view: View) : GenericViewHolder<ItemViewModel>(view) {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bind(itemVM: ItemViewModel, fragmentBase: FragmentBase) {

        itemView.find<TextView>(R.id.tvName).text = itemVM.item.name
        itemView.find<TextView>(R.id.tvCode).text = itemVM.item.code

        val tvAmount = itemView.find<TextView>(R.id.tvAmountPos)
        val imgState = itemView.find<ImageView>(R.id.imgState)

        imgState.visibility = View.VISIBLE

        when (fragmentBase) {

            is ScannedListFragment -> {
                tvAmount.text = itemVM.item.endNumber.toString()
                val isHandleAdded = itemVM.item.itemState == itemView.context.resources.getString(R.string.handle)
                showImage(isHandleAdded, imgState)

                when (itemVM.getStatus()) {
                    ItemStatus.Brak -> tvAmount.setTextColor(itemVM.context.getColor(R.color.red200))
                    ItemStatus.Nadwyzka -> tvAmount.setTextColor(itemVM.context.getColor(R.color.blue400))
                    ItemStatus.Zgodny -> tvAmount.setTextColor(itemVM.context.getColor(R.color.teal400))
                }
            }

            is EmptyListFragment -> {
                val isHandleAdded = itemVM.item.user.isBlank()
                showImage(isHandleAdded, imgState)
                tvAmount.text = itemVM.item.startNumber.toString()
            }
        }
    }

    private fun showImage(isHandleAdded: Boolean, imgState: ImageView) {
        if (isHandleAdded)
            Glide.with(itemView).load(itemView.context.resources.getDrawable(R.drawable.handle)).into(imgState)
        else
            Glide.with(itemView).load(itemView.context.resources.getDrawable(R.drawable.barcode)).into(imgState)
    }
}