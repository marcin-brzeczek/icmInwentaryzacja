package de.wasiakgruppe.numbers

val Byte.Companion.MASK get() = 0xFF
val Short.Companion.MASK get() = 0xFFFF

fun ByteArray.toHexString() = this.joinToString(separator=" ", prefix = "[", postfix = "]", transform = { Integer.toHexString(it.toInt() and Byte.MASK) })
fun ShortArray.toHexString() = this.joinToString(separator=" ", prefix = "[", postfix = "]", transform = { Integer.toHexString(it.toInt() and Short.MASK) })