package com.income.icminwentaryzacja.fragments.adapter

import android.app.Activity
import android.graphics.*
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminwentaryzacja.views.ChangeAmountDialogFragment

class ItemSwipeHelper(var adapter: ItemAdapter, var activity: Activity, var reloadListenr: IOnReloadAdapterListener, dragDirs: Int = 0, swipeDirs: Int = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

        val position = viewHolder.adapterPosition

        if (direction == ItemTouchHelper.LEFT) {
        val currentItem: Item = (adapter.items[position] as ItemViewModel).item
            currentItem.endNumber = 0.0
            currentItem.save()
            adapter.removeItem(position)
            reloadListenr.reload()

        } else {
        val currentItem: Item = (adapter.items[position] as ItemViewModel).item
            val changeAmountDialogFragment = ChangeAmountDialogFragment(currentItem, reloadListenr)
            val ft = (activity as MainActivity).supportFragmentManager
            changeAmountDialogFragment.show(ft, "dialog")
            adapter.notifyDataSetChanged()
        }
    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

        val icon: Bitmap
        val p = Paint()
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

            val itemView = viewHolder.itemView
            val height = itemView.bottom.toFloat() - itemView.top.toFloat()
            val width = height / 3

            if (dX > 0) {
                p.color = activity.resources.getColor(R.color.teal400)
                val background = RectF(itemView.left.toFloat(), itemView.top.toFloat(), dX, itemView.bottom.toFloat())
                c.drawRect(background, p)
                icon = BitmapFactory.decodeResource(activity.resources, R.drawable.edit_pencil)
                val icon_dest = RectF(itemView.left.toFloat() + width, itemView.top.toFloat() + width, itemView.left.toFloat() + 2 * width, itemView.bottom.toFloat() - width)
                c.drawBitmap(icon, null, icon_dest, p)
            } else {
                p.color = activity.resources.getColor(R.color.red)
                val background = RectF(itemView.right.toFloat() + dX, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
                c.drawRect(background, p)
                icon = BitmapFactory.decodeResource(activity.resources, R.drawable.trash)
                val icon_dest = RectF(itemView.right.toFloat() - 2 * width, itemView.top.toFloat() + width, itemView.right.toFloat() - width, itemView.bottom.toFloat() - width)
                c.drawBitmap(icon, null, icon_dest, p)
            }
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}