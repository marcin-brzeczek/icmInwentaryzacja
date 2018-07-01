@file:Suppress("NOTHING_TO_INLINE")

// Inlining needs to be enforced for optimization here

package de.wasiakgruppe.numbers

class UByteArray {
    constructor(size: Int) {
        _bytes = ByteArray(size)
    }

    constructor(size: Int, init: (Int) -> UByte) {
        _bytes = ByteArray(size, { init(it).toByte() })
    }

    internal constructor(base: ByteArray) {
        _bytes = base
    }

    constructor(base: Array<out UByte>) {
        _bytes = base.map { it.toByte() }.toByteArray()
    }

    constructor(base: Collection<out UByte>) {
        _bytes = base.map { it.toByte() }.toByteArray()
    }

    private val _bytes: ByteArray

    val size get() = _bytes.size

    val raw get() = _bytes

    operator fun get(index: Int) = _bytes[index].toUByte()

    operator fun set(index: Int, value: UByte) {
        _bytes[index] = value.toByte()
    }

    /** An iterator over a sequence of values of type `UByte`. */
    operator fun iterator() = object : Iterator<UByte> {
        private val _byteIterator = _bytes.iterator()

        override fun next() = _byteIterator.next().toUByte()
        override fun hasNext() = _byteIterator.hasNext()
    }
}

/**
 * Returns `true` if the two specified arrays are *structurally* equal to one another,
 * i.e. contain the same number of the same elements in the same order.
 */
@SinceKotlin("1.1")
inline infix fun UByteArray.contentEquals(other: UByteArray): Boolean = java.util.Arrays.equals(this.raw, other.raw)

/** Returns an array containing the specified [UByte] numbers. */
inline fun ubyteArrayOf(vararg elements: UByte) = UByteArray(elements)

/** Returns an array containing the specified [UByte] numbers. */
inline fun ubyteArrayOf(vararg elements: Int) = UByteArray(elements.map { it.toUByte() })

/** Returns an array containing the array of [UByte]. */
inline fun ByteArray.toUByteArray() = UByteArray(this.size, { this[it].toUByte() })

/** Returns an array containing the array of [UByte]. Returned array will wrap source so any changes will appear in both collections. */
fun ByteArray.asUByteArray() = UByteArray(this)

/** Returns an array containing the array of [Byte]. */
inline fun UByteArray.toByteArray() = this.raw

/** Returns a list containing elements at indices in the specified [indices] range. */
inline fun UByteArray.slice(indices: IntRange): List<UByte> = if (indices.isEmpty()) listOf() else raw.copyOfRange(indices.start, indices.endInclusive + 1).map { it.toUByte() }

inline fun UByteArray.toHexString() = this.raw.toHexString()