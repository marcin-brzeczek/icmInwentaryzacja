package de.wasiakgruppe.numbers

import java.io.Serializable
import java.math.BigInteger

abstract class UNumber : Number(), Serializable {
    open fun toBigInteger(): BigInteger = BigInteger(toString())

    abstract override fun toByte(): Byte
    abstract override fun toChar(): Char
    abstract override fun toShort(): Short
    abstract override fun toInt(): Int
    abstract override fun toLong(): Long
    abstract override fun toFloat(): Float
    abstract override fun toDouble(): Double
    abstract override fun toString(): String
}