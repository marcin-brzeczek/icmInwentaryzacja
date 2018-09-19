package com.income.icminventory.utilities


import android.support.annotation.LayoutRes
import android.support.design.widget.TextInputLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

inline fun <R> LayoutInflater.inflate(@LayoutRes id: Int, root: ViewGroup? = null, attachToRoot: Boolean = false, block: View.() -> R): View =
        with(this.inflate(id, root, attachToRoot)) {
            block.invoke(this)

            return this
        }

inline fun LayoutInflater.inflate(@LayoutRes id: Int): View = inflate(id, null, false)

//inline fun <T : ViewDataBinding> LayoutInflater.inflateBinding(@LayoutRes id: Int, root: ViewGroup? = null, attachToRoot: Boolean = false): T =
//        inflate(this, id, root, attachToRoot)

@Suppress("UNCHECKED_CAST")
inline fun <T> LayoutInflater.inflateViewWithProperties(@LayoutRes id: Int, root: ViewGroup? = null, attachToRoot: Boolean = false, block: T.() -> Unit): T =
        (inflate(id, root, attachToRoot) as T).apply { block() }


