package com.income.icminwentaryzacja.views

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.adapter.IOnReloadAdapterListener

@SuppressLint("ValidFragment")
class ChangeAmountDialogFragment(val item: Item, val onReloadAdapterListener: IOnReloadAdapterListener) : DialogFragment() {

    var currentAmount: Double = 0.0
    private var amount = ""
    private lateinit var tvAmount: TextView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val alertDialog = AlertDialog.Builder(activity)
        val alert = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        val inflater = activity.layoutInflater
        val v = inflater.inflate(R.layout.dialog_change_amount, null)
        val bOK = v.findViewById(R.id.bOK) as Button
        val imgRemove = v.findViewById(R.id.imgRemoveAmount) as ImageView
        val imgAdd = v.findViewById(R.id.imgAddAmount) as ImageView
        tvAmount = v.findViewById(R.id.tvAmount) as TextView
        tvAmount.text = item.endNumber.toString()

        bOK.setOnClickListener {
            removeView()
            item.endNumber = tvAmount.text.toString().toDouble()
            item.itemState = activity.getString(R.string.handle)
            item.save()
            onReloadAdapterListener.reload()
            alert.cancel()
        }

        imgRemove.setOnClickListener { setAmount();tvAmount.text = if (currentAmount > 1.0) (--currentAmount).toString() + "" else "1.0" }
        imgAdd.setOnClickListener { setAmount();tvAmount.text = (++currentAmount).toString() + "" }

        alert.setView(v)
        alertDialog.create()
        return alert
    }

    private fun setAmount() {
        amount = if (tvAmount.getText().toString() != null && tvAmount.getText().toString().length > 1)
            tvAmount.getText().toString()
        else
            "1.0"
        currentAmount = java.lang.Double.valueOf(amount)
    }

    private fun removeView() {
        if (view?.parent != null) {
            (view?.parent as ViewGroup)?.removeView(view)
        }
    }
}