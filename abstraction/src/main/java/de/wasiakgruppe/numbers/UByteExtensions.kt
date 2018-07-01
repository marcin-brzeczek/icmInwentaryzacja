// Operators must be inlined
// Some methods may appear unused
@file:Suppress("NOTHING_TO_INLINE", "unused")

package de.wasiakgruppe.numbers

//region Creation

/** Simple creator of the `unsigned byte` with given [value]. */
inline fun ubyte(value:Int) = UByte.valueOf(value)

//endregion Creation
//region Addition

/** Adds the [other] value to this value. */
inline infix operator fun UByte.plus(other: Number) = UByte.valueOf(this.toInt() + other.toInt())
/** Adds the [other] value to this value. */
inline infix operator fun UByte.plus(other: Int) = UByte.valueOf(this.toInt() + other)

//endregion Addition
//region Subtraction

/** Subtracts the [other] value from this value. */
inline infix operator fun UByte.minus(other: UByte) = UByte.valueOf(this.toInt() - other.toInt())
/** Subtracts the [other] value from this value. */
inline infix operator fun UByte.minus(other: Byte) = UByte.valueOf(this.toInt() - other.toInt())
/** Subtracts the [other] value from this value. */
inline infix operator fun UByte.minus(other: Int) = UByte.valueOf(this.toInt() - other)

//endregion Subtraction
//region Multiplication

/** Multiplies this value by the [other] value. */
inline infix operator fun UByte.times(other: UByte) = UByte.valueOf(this.toInt() * other.toInt())
/** Multiplies this value by the [other] value. */
inline infix operator fun UByte.times(other: Byte) = UByte.valueOf(this.toInt() * other.toInt())
/** Multiplies this value by the [other] value. */
inline infix operator fun UByte.times(other: Int) = UByte.valueOf(this.toInt() * other)

//endregion Multiplication
//region Division

/** Divides this value by the [other] value. */
inline infix operator fun UByte.div(other: UByte) = UByte.valueOf(this.toInt() / other.toInt())
/** Divides this value by the [other] value. */
inline infix operator fun UByte.div(other: Byte) = UByte.valueOf(this.toInt() / other.toInt())
/** Divides this value by the [other] value. */
inline infix operator fun UByte.div(other: Int) = UByte.valueOf(this.toInt() / other)


/** Calculates the remainder of dividing this value by the [other] value. */
inline infix operator fun UByte.rem(other: UByte) = UByte.valueOf(this.toInt() % other.toInt())
/** Calculates the remainder of dividing this value by the [other] value. */
inline infix operator fun UByte.rem(other: Byte) = UByte.valueOf(this.toInt() % other.toInt())
/** Calculates the remainder of dividing this value by the [other] value. */
inline infix operator fun UByte.rem(other: Int) = UByte.valueOf(this.toInt() % other)

//endregion Division
//region Bitwise comparison

/** Performs a bitwise AND operation between the two values. */
inline infix fun UByte.and(other: UByte) = UByte.valueOf(this.toInt() and other.toInt())
/** Performs a bitwise AND operation between the two values. */
inline infix fun UByte.and(other: Byte) = UByte.valueOf(this.toInt() and other.toInt())
/** Performs a bitwise AND operation between the two values. */
inline infix fun UByte.and(other: Int) = UByte.valueOf(this.toInt() and other)

/** Performs a bitwise OR operation between the two values. */
inline infix fun UByte.or(other: UByte) = UByte.valueOf(this.toInt() or other.toInt())
/** Performs a bitwise OR operation between the two values. */
inline infix fun UByte.or(other: Byte) = UByte.valueOf(this.toInt() or other.toInt())
/** Performs a bitwise OR operation between the two values. */
inline infix fun UByte.or(other: Int) = UByte.valueOf(this.toInt() or other)

/** Performs a bitwise XOR operation between the two values. */
inline infix fun UByte.xor(other: UByte) = UByte.valueOf(this.toInt() xor other.toInt())
/** Performs a bitwise XOR operation between the two values. */
inline infix fun UByte.xor(other: Byte) = UByte.valueOf(this.toInt() xor other.toInt())
/** Performs a bitwise XOR operation between the two values. */
inline infix fun UByte.xor(other: Int) = UByte.valueOf(this.toInt() xor other)

//endregion Bitwise comparison
//region Bitwise shifting

/** Shifts this value left by [bits]. */
inline infix fun UByte.shl(bits: Int) = UByte.valueOf(this.toInt() shl bits)

/** Shifts this value right by [bits], filling the leftmost bits with zeros. */
inline infix fun UByte.shr(bits: Int) = UByte.valueOf(this.toInt() ushr bits)

/** Shifts this value right by [bits], filling the leftmost bits with zeros. */
inline infix fun UByte.ushr(bits: Int) = UByte.valueOf(this.toInt() ushr bits)

//endregion Bitwise shifting
//region Unary operations

/** Increments this value. */
inline operator fun UByte.inc() = UByte.valueOf(this.toInt() + 1)
/** Decrements this value. */
inline operator fun UByte.dec() = UByte.valueOf(this.toInt() - 1)

//endregion Unary operations
//region Conversions

/** Converts number to UByte (`unsigned Byte`) */
inline fun Byte.toUByte() = UByte.valueOf(this.toInt())
/** Converts number to UByte (`unsigned Byte`) */
inline fun Short.toUByte() = UByte.valueOf(this.toInt())
/** Converts number to UByte (`unsigned Byte`) */
inline fun Int.toUByte() = UByte.valueOf(this)
/** Converts number to UByte (`unsigned Byte`) */
inline fun Long.toUByte() = UByte.valueOf(this.toInt())
/** Converts number to UByte (`unsigned Byte`) */
inline fun Float.toUByte() = UByte.valueOf(this.toInt())
/** Converts number to UByte (`unsigned Byte`) */
inline fun Double.toUByte() = UByte.valueOf(this.toInt())
/** Converts number to UByte (`unsigned Byte`) */
inline fun String.toUByte() = UByte.valueOf(this.toInt())
/** Converts number to UByte (`unsigned Byte`) */
inline fun UShort.toUByte() = UByte.valueOf(this.toInt())

//endregion Conversions
//region Range checking

inline fun UByte.Companion.checkRange(value: Number) = value in UByte.MIN_VALUE_MASK..UByte.MAX_VALUE_MASK

//endregion Range checking