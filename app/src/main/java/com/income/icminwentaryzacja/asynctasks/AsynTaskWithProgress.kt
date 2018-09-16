package com.income.icminwentaryzacja.asynctasks

import android.annotation.SuppressLint
import android.app.Activity
import android.os.AsyncTask
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.fragments.scan_positions.InfoDialogFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ProgressDialogFragment

@SuppressLint("StaticFieldLeak")
class AsyncTaskWithProgress(val activity: Activity, private val doInBackground: () -> Unit, private val onPostExecute: () -> Unit) : AsyncTask<Void, Void, Boolean>() {

    private var progressDialogFragment: ProgressDialogFragment? = (activity as MainActivity).progressDialogFragment

    private val ft = (activity as MainActivity).fragmentManager
    var exc: Exception? = null

    override fun onPreExecute() {

        progressDialogFragment?.show(ft, "dialog")
    }

    override fun doInBackground(vararg params: Void?): Boolean {
        try {
            doInBackground.invoke()
        } catch (e: Exception) {
            exc = e
        }
        return exc != null
    }

    override fun onPostExecute(result: Boolean) {
        if (result) {
            if((activity as MainActivity).isActivityResume)
            InfoDialogFragment({ progressDialogFragment?.dismiss() }, activity.baseContext.getString(R.string.error_ocurred) + " ${exc.toString()}").show((activity as MainActivity).fragmentManager, "dialog")
        } else {
            onPostExecute.invoke()
            progressDialogFragment?.dismiss()
        }
    }
}