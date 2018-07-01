package de.wasiakgruppe.common

import java.lang.ref.WeakReference

inline fun <T, R> WeakReference<T>.safeRun(block: T.() -> R): R? = this.get()?.run(block)