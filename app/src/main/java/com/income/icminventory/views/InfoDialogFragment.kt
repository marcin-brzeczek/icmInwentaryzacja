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
import android.widget.TextView
import com.income.icminventory.R


@SuppressLint("ValidFragment")
class InfoDialogFragment(private val block: () -> Unit, val text: String, private val isWebLink: Boolean = false) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog = AlertDialog.Builder(activity)
        val alert = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        val inflater = activity.layoutInflater
        val v = inflater.inflate(R.layout.dialog_info, null)
        val title = v.findViewById(R.id.tvTitle) as TextView
        val tvDownload = v.findViewById(R.id.tvDownload) as TextView
        title.text = text

        if (isWebLink) {
            tvDownload.visibility = View.VISIBLE
            tvDownload.setOnClickListener {
                val url = getString(R.string.go_to_google_play_link)
                val i = Intent(ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
        }

        v.findViewById(R.id.bOk).setOnClickListener {
            block.invoke()
            dismiss()
        }
        alert.setView(v)
        alertDialog.create()
        return alert
    }
}