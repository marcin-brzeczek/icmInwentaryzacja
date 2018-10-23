package com.income.icminventory.utilities

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.zhuinden.simplestack.Backstack
import com.income.icminventory.backstack.BackstackService
import com.income.icminventory.backstack.BaseRoute
import com.income.icminventory.fragments.abstraction.FragmentBase

//TODO: after deleting current fragment general base, delete these extension methods
fun FragmentBase.getBackStack(): Backstack = BackstackService.get(activity)

fun FragmentBase.showError(ctx:Context, message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(ctx, message, length).show()
}

@Deprecated("Use route instead", ReplaceWith("route"))
val FragmentBase.key: Any?
    get() = arguments.get("KEY")

val FragmentBase.route: BaseRoute? get() = arguments.get("KEY") as? BaseRoute

fun FragmentBase.toast(message: CharSequence, duration: Int =  Toast.LENGTH_SHORT) = Toast.makeText(activity, message, duration).show()

fun FragmentBase.hideKeyboard(view: View){
        if (view.requestFocus()) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }
}