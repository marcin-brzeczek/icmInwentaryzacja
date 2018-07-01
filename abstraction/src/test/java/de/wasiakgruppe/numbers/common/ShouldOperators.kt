package de.wasiakgruppe.numbers.common

import de.wasiakgruppe.numbers.UByte
import org.junit.Assert

internal infix fun UByte.shouldEqual(expected: Byte) = Assert.assertEquals(expected, toByte())
internal infix fun UByte.shouldEqual(expected: Short) = Assert.assertEquals(expected, toShort())
internal infix fun UByte.shouldEqual(expected: Int) = Assert.assertEquals(expected, toInt())
internal infix fun UByte.shouldEqual(expected: Long) = Assert.assertEquals(expected, toLong())
internal infix fun UByte.shouldEqual(expected: Float) = Assert.assertEquals(expected, toFloat(), 0.000001F)
internal infix fun UByte.shouldEqual(expected: Double) = Assert.assertEquals(expected, toDouble(), 0.000001)

internal infix fun <T1 : Any, T2 : Any> T1.shouldEqual(expected: T2) = Assert.assertEquals(expected, this)

internal infix fun <T1, T2> Array<T1>.shouldContentEqual(expected: Array<T2>) = Assert.assertArrayEquals(this, expected)
internal infix fun ByteArray.shouldContentEqual(expected: ByteArray) = Assert.assertArrayEquals(this, expected)
