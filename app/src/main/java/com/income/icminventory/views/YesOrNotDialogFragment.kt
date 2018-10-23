package com.income.icminventory.views

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.DialogFragment
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.income.icminventory.R
import org.jetbrains.anko.find


@SuppressLint("ValidFragment")
class YesOrNotDialogFragment(private val blockYesClick: () -> Unit,private val blockNoClick: () -> Unit,  val text: String) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog = AlertDialog.Builder(activity)
        val alert = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        val inflater = activity.layoutInflater
        val v = inflater.inflate(R.layout.dialog_yes_or_not, null)
        val title = v.find<TextView>(R.id.tvTitle)
        title.text = text

        v.find<Button>(R.id.bNo).setOnClickListener {
            blockNoClick.invoke()
            dismiss()
        }
        v.find<Button>(R.id.bYes).setOnClickListener {
            blockYesClick.invoke()
            dismiss()
        }

        alert.setView(v)
        alertDialog.create()
        return alert
    }
}