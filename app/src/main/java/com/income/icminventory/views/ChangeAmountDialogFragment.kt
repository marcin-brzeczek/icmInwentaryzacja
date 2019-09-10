package com.income.icminventory.views

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.income.icminventory.R
import com.income.icminventory.database.dto.Item
import com.income.icminventory.fragments.adapter.IOnReloadAdapterListener
import org.jetbrains.anko.find

@SuppressLint("ValidFragment")
class ChangeAmountDialogFragment(val item: Item, val onReloadAdapterListener: IOnReloadAdapterListener) : DialogFragment() {

    var currentAmount: Double = 0.0
    private var amount = ""
    private lateinit var tvAmount: TextView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val alertDialog = AlertDialog.Builder(context)
        val alert = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        val inflater = activity?.layoutInflater
        val v = inflater?.inflate(R.layout.dialog_change_amount, null)
        v?.find<TextView>(R.id.tvCode)?.text = item.code
        v?.find<TextView>(R.id.tvName)?.text = item.name
        val bOK = v?.find<TextView>(R.id.bOK) as Button
        val imgRemove = v?.find<ImageView>(R.id.imgRemoveAmount)
        val imgAdd = v?.find<ImageView>(R.id.imgAddAmount)
        tvAmount = v?.find<TextView>(R.id.tvAmount)
        tvAmount.text = item.endNumber.toString()

        bOK.setOnClickListener {
            removeView()
            item.endNumber = tvAmount.text.toString().toDouble()
            item.itemState = context!!.getString(R.string.handle)
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