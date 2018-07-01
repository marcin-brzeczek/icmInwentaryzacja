package de.wasiakgruppe.numbers

import java.math.BigInteger

/**
 * The `unsigned short` type
 *
 * @author Szymon Kraus
 * @author Karol Stasinski
 */
class UShort private constructor(value: Int) : UNumber(), Comparable<Number> {
    /** The _value modelling the content of this `unsigned short` */
    private val _value: Int = value and MAX_VALUE_MASK

    override fun toByte(): Byte = _value.toByte()
    override fun toChar(): Char = _value.toChar()
    override fun toShort(): Short = _value.toShort()
    override fun toInt(): Int = _value
    override fun toLong(): Long = _value.toLong()
    override fun toFloat(): Float = _value.toFloat()
    override fun toDouble(): Double = _value.toDouble()
    override fun toBigInteger(): BigInteger = BigInteger.valueOf(_value.toLong())

    override fun hashCode(): Int = Integer.valueOf(_value)!!.hashCode()
    override fun equals(other: Any?): Boolean = this === other || if (other is Number) other == this.toInt() else false
    override fun compareTo(other: Number): Int = if (this._value < other.toInt()) -1 else if (this._value == other.toInt()) 0 else 1

    override fun toString(): String = Integer.valueOf(_value)!!.toString()

    @Suppress("unused")
    companion object {
        /** Generated UID */
        private val serialVersionUID = -1634613316843254L

        /** Number of bits required to store [UShort] */
        const val BITS = 16

        /** Minimum (0x0000) bit mask of `unsigned short` */
        const val MIN_VALUE_MASK = 0x0000

        /** Maximum (0xffff) bit mask of `unsigned short` */
        const val MAX_VALUE_MASK = 0xffff

        /** Number up to which values are cached (fly-weight pattern implementation) */
        private const val CACHED_THRESHOLD = 0x00ff

        /** Cached values (fly-weight pattern implementation) */
        private val CACHED_VALUES = Array(CACHED_THRESHOLD + 1, { i -> UShort(i) })

        /** Method returning `unsigned short` representing given value */
        fun valueOf(value: Int) = if (value in MIN_VALUE_MASK..CACHED_THRESHOLD) CACHED_VALUES[value and MAX_VALUE_MASK] else UShort(value and MAX_VALUE_MASK)

        /** A constant holding the minimum value an `unsigned short` can have, 0. */
        val MIN_VALUE = valueOf(MIN_VALUE_MASK)

        /** A constant holding the maximum value an `unsigned short` can have, 2<sup>16</sup>-1. */
        val MAX_VALUE = valueOf(MAX_VALUE_MASK)
    }
}
