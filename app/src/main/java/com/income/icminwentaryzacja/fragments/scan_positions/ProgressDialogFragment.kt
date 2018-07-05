package com.income.icminwentaryzacja.fragments.scan_positions

import android.app.Dialog
import android.app.DialogFragment
import android.app.ProgressDialog
import android.os.Bundle
import com.income.icminwentaryzacja.R


class ProgressDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        val dialog = ProgressDialog(getActivity(), getTheme())
        dialog.setTitle("Trwa odczyt z pliku...")
        dialog.setMessage("")
        dialog.isIndeterminate = true
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        return dialog
    }
}