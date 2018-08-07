package com.income.icminwentaryzacja.utilities



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