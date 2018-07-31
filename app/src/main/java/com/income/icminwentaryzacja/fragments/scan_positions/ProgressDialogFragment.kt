package com.income.icminwentaryzacja.fragments.scan_positions

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.income.icminwentaryzacja.R

@SuppressLint("ValidFragment")
class ProgressDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog = AlertDialog.Builder(activity)
        val alert = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        val inflater = activity.layoutInflater
        val v = inflater.inflate(R.layout.progress_dialog, null)
        alert.setView(v)
        alertDialog.create()
        return alert
    }
}