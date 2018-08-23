package com.income.icminwentaryzacja.utilities

import android.content.Context
import android.widget.EditText
import com.income.icminwentaryzacja.R


object Functions {
    val DoNothing: Unit = Unit
}

inline fun <T> T.alsoIf(predicate: T.() -> Boolean, block: T.() -> Unit): Boolean {
    val result = predicate.invoke(this)
    if (result) block.invoke(this)
    return result
}

inline fun <T> T.alsoUnless(predicate: T.() -> Boolean, block: T.() -> Unit): Boolean {
    val result = predicate.invoke(this)
    if (!result) block.invoke(this)
    return result
}

inline fun executeIf(predicate: () -> Boolean, block: () -> Unit) {
    val result = predicate.invoke()
    if (result) block.invoke()
}

inline fun executeUnless(predicate: () -> Boolean, block: () -> Unit) {
    val result = predicate.invoke()
    if (!result) block.invoke()
}


inline fun withoutNullOrBlank(vararg items: String?) = items.filterNot { it.isNullOrBlank() }

inline fun displayError(vararg inputTexts: EditText, context:Context) {
    inputTexts.filter { it.text.isEmpty() }.forEach { it.requestFocus(); it.text.clear(); it.error = context.resources.getString(R.string.fill_value) }
}