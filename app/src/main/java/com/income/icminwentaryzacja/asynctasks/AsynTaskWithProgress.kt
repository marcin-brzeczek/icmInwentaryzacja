package com.income.icminwentaryzacja.asynctasks

import android.annotation.SuppressLint
import android.app.Activity
import android.os.AsyncTask
import com.income.icminwentaryzacja.activities.MainActivity
import com.income.icminwentaryzacja.fragments.scan_positions.ProgressDialogFragment

@SuppressLint("StaticFieldLeak")
class AsyncTaskWithProgress(activity: Activity, private val doInBackground: () -> Unit, private val onPostExecute: () -> Unit) : AsyncTask<Void, Void, Boolean>() {
    private val progressDialogFragment = ProgressDialogFragment()
    private val ft = (activity as MainActivity).fragmentManager

    override fun onPreExecute() {
        progressDialogFragment.show(ft, "dialog")
    }

    override fun doInBackground(vararg params: Void?): Boolean {
        doInBackground.invoke()
        return true
    }

    override fun onPostExecute(result: Boolean?) {
        onPostExecute.invoke()
        progressDialogFragment.dismiss()
    }
}