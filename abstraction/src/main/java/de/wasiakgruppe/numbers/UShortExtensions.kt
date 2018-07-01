// Operators must be inlined
// Some methods may appear unused
@file:Suppress("NOTHING_TO_INLINE", "unused")

package de.wasiakgruppe.numbers

//region Addition

/** Adds the [other] value to this value. */
inline infix operator fun UShort.plus(other: UShort) = UShort.valueOf(this.toInt() + other.toInt())
/** Adds the [other] value to this value. */
inline infix operator fun UShort.plus(other: Short) = UShort.valueOf(this.toInt() + other.toInt())
/** Adds the [other] value to this value. */
inline infix operator fun UShort.plus(other: Int) = UShort.valueOf(this.toInt() + other)

//endregion Addition
//region Subtraction

/** Subtracts the [other] value from this value. */
inline infix operator fun UShort.minus(other: UShort) = UShort.valueOf(this.toInt() - other.toInt())
/** Subtracts the [other] value from this value. */
inline infix operator fun UShort.minus(other: Short) = UShort.valueOf(this.toInt() - other.toInt())
/** Subtracts the [other] value from this value. */
inline infix operator fun UShort.minus(other: Int) = UShort.valueOf(this.toInt() - other)

//endregion Subtraction
//region Multiplication

/** Multiplies this value by the [other] value. */
inline infix operator fun UShort.times(other: UShort) = UShort.valueOf(this.toInt() * other.toInt())
/** Multiplies this value by the [other] value. */
inline infix operator fun UShort.times(other: Short) = UShort.valueOf(this.toInt() * other.toInt())
/** Multiplies this value by the [other] value. */
inline infix operator fun UShort.times(other: Int) = UShort.valueOf(this.toInt() * other)

//endregion Multiplication
//region Division

/** Divides this value by the [other] value. */
inline infix operator fun UShort.div(other: UShort) = UShort.valueOf(this.toInt() / other.toInt())
/** Divides this value by the [other] value. */
inline infix operator fun UShort.div(other: Short) = UShort.valueOf(this.toInt() / other.toInt())
/** Divides this value by the [other] value. */
inline infix operator fun UShort.div(other: Int) = UShort.valueOf(this.toInt() / other)


/** Calculates the remainder of dividing this value by the [other] value. */
inline infix operator fun UShort.rem(other: UShort) = UShort.valueOf(this.toInt() % other.toInt())
/** Calculates the remainder of dividing this value by the [other] value. */
inline infix operator fun UShort.rem(other: Short) = UShort.valueOf(this.toInt() % other.toInt())
/** Calculates the remainder of dividing this value by the [other] value. */
inline infix operator fun UShort.rem(other: Int) = UShort.valueOf(this.toInt() % other)

//endregion Division
//region Bitwise comparison

/** Performs a bitwise AND operation between the two values. */
inline infix fun UShort.and(other: UShort) = UShort.valueOf(this.toInt() and other.toInt())
/** Performs a bitwise AND operation between the two values. */
inline infix fun UShort.and(other: Short) = UShort.valueOf(this.toInt() and other.toInt())
/** Performs a bitwise AND operation between the two values. */
inline infix fun UShort.and(other: Int) = UShort.valueOf(this.toInt() and other)

/** Performs a bitwise OR operation between the two values. */
inline infix fun UShort.or(other: UShort) = UShort.valueOf(this.toInt() or other.toInt())
/** Performs a bitwise OR operation between the two values. */
inline infix fun UShort.or(other: Short) = UShort.valueOf(this.toInt() or other.toInt())
/** Performs a bitwise OR operation between the two values. */
inline infix fun UShort.or(other: Int) = UShort.valueOf(this.toInt() or other)

/** Performs a bitwise XOR operation between the two values. */
inline infix fun UShort.xor(other: UShort) = UShort.valueOf(this.toInt() xor other.toInt())
/** Performs a bitwise XOR operation between the two values. */
inline infix fun UShort.xor(other: Short) = UShort.valueOf(this.toInt() xor other.toInt())
/** Performs a bitwise XOR operation between the two values. */
inline infix fun UShort.xor(other: Int) = UShort.valueOf(this.toInt() xor other)

//endregion Bitwise comparison
//region Bitwise shifting

/** Shifts this value left by [bits]. */
inline infix fun UShort.shl(bits: Int) = UShort.valueOf(this.toInt() shl bits)

/** Shifts this value right by [bits], filling the leftmost bits with zeros. */
inline infix fun UShort.shr(bits: Int) = UShort.valueOf(this.toInt() ushr bits)

/** Shifts this value right by [bits], filling the leftmost bits with zeros. */
inline infix fun UShort.ushr(bits: Int) = UShort.valueOf(this.toInt() ushr bits)

//endregion Bitwise shifting
//region Unary operations

/** Increments this value. */
inline operator fun UShort.inc() = UShort.valueOf(this.toInt() + 1)
/** Decrements this value. */
inline operator fun UShort.dec() = UShort.valueOf(this.toInt() - 1)

//endregion Unary operations
//region Conversions

/** Converts number to UShort (`unsigned short`) */
inline fun Byte.toUShort() = UShort.valueOf(this.toInt())
/** Converts number to UShort (`unsigned short`) */
inline fun Short.toUShort() = UShort.valueOf(this.toInt())
/** Converts number to UShort (`unsigned short`) */
inline fun Int.toUShort() = UShort.valueOf(this)
/** Converts number to UShort (`unsigned short`) */
inline fun Long.toUShort() = UShort.valueOf(this.toInt())
/** Converts number to UShort (`unsigned short`) */
inline fun Float.toUShort() = UShort.valueOf(this.toInt())
/** Converts number to UShort (`unsigned short`) */
inline fun Double.toUShort() = UShort.valueOf(this.toInt())
/** Converts number to UShort (`unsigned short`) */
inline fun String.toUShort() = UShort.valueOf(this.toInt())

//endregion Conversions
//region Range checking

inline fun UShort.Companion.checkRange(value: Number) = value in UShort.MIN_VALUE_MASK..UShort.MAX_VALUE_MASK

//endregion Range checking
