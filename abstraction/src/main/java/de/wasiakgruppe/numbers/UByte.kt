package de.wasiakgruppe.numbers

import java.math.BigInteger

/**
 * The `unsigned byte` type
 *
 * @author Szymon Kraus
 * @author Karol Stasinski
 */
class UByte private constructor(value: Int) : UNumber(), Comparable<Number> {
    /** The _value modelling the content of this `unsigned byte` */
    private val _value: Short = (value and MAX_VALUE_MASK).toShort()

    override fun toByte(): Byte = _value.toByte()
    override fun toChar(): Char = _value.toChar()
    override fun toShort(): Short = _value
    override fun toInt(): Int = _value.toInt()
    override fun toLong(): Long = _value.toLong()
    override fun toFloat(): Float = _value.toFloat()
    override fun toDouble(): Double = _value.toDouble()
    override fun toBigInteger(): BigInteger = BigInteger.valueOf(_value.toLong())

    override fun hashCode(): Int = _value.hashCode()
    override fun equals(other: Any?): Boolean = this === other || other is Number && other.toLong() == this.toLong()
    override fun compareTo(other: Number): Int = if (this._value < other.toInt()) -1 else if (this._value.toInt() == other.toInt()) 0 else 1

    override fun toString(): String = _value.toString()

    @Suppress("unused")
    companion object {
        /** Generated UID */
        private val serialVersionUID = -1634613216843254L

        /** Number of bits required to store [UByte] */
        const val BITS = 8

        /** Minimum (0x00) bit mask of `unsigned byte` */
        const val MIN_VALUE_MASK = 0x00

        /** Maximum (0xff) bit mask of `unsigned byte` */
        const val MAX_VALUE_MASK = 0xff

        /** Number up to which values are cached (fly-weight pattern implementation) */
        private const val CACHED_THRESHOLD = MAX_VALUE_MASK

        /** Cached values (fly-weight pattern implementation) */
        private val CACHED_VALUES = Array(CACHED_THRESHOLD + 1, { i -> UByte(i) })

        /** Method returning `unsigned byte` representing given value */
        fun valueOf(value: Int) = if (value in MIN_VALUE_MASK..CACHED_THRESHOLD) CACHED_VALUES[value and MAX_VALUE_MASK] else UByte(value and MAX_VALUE_MASK)

        /** A constant holding the minimum _value an `unsigned byte` can have, 0. */
        val MIN_VALUE = valueOf(MIN_VALUE_MASK)

        /** A constant holding the maximum _value an `unsigned byte` can have, 2<sup>8</sup>-1. */
        val MAX_VALUE = valueOf(MAX_VALUE_MASK)
    }
}

