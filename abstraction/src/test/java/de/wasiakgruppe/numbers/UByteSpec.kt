package de.wasiakgruppe.numbers

import de.wasiakgruppe.numbers.common.givenNumbers
import de.wasiakgruppe.numbers.common.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertSame

object UByteSpec : Spek({
    group("Conversions") {
        given("x = ubyte(1)") {
            val x = ubyte(1)

            it("should equal Byte<1>"){
                x shouldEqual 1.toByte()
            }

            it("should equal Short<1>"){
                x shouldEqual 1.toShort()
            }

            it("should equal Int<1>"){
                x shouldEqual 1
            }

            it("should equal Long<1>"){
                x shouldEqual 1L
            }

            it("should equal Float<1.0>"){
                x shouldEqual 1.0F
            }

            it("should equal Double<1.0>"){
                x shouldEqual 1.0
            }

        }

        given("x = ubyte(1) as UNumber") {
            val x = ubyte(1) as UNumber

            on("cast to Byte") {
                it("should equal Byte<1>") {
                    x.toByte() shouldEqual 1.toByte()
                }
            }

            on("cast to Short") {
                it("should equal Short<1>") {
                    x.toShort() shouldEqual 1.toShort()
                }
            }

            on("cast to Int") {
                it("should equal Int<1>") {
                    x.toInt() shouldEqual 1
                }
            }

            on("cast to Long") {
                it("should equal Long<1>") {
                    x.toLong() shouldEqual 1L
                }
            }

            on("cast to Float") {
                it("should equal Float<1.0>") {
                    x.toFloat() shouldEqual 1.0F
                }
            }

            on("cast to Double") {
                it("should equal Double<1.0>") {
                    x.toDouble() shouldEqual 1.0
                }
            }

        }

        given("x = ubyte(1) as Number") {
            val x = ubyte(1) as Number

            on("cast to Byte") {
                it("should equal Byte<1>") {
                    x.toByte() shouldEqual 1.toByte()
                }
            }

            on("cast to Short") {
                it("should equal Short<1>") {
                    x.toShort() shouldEqual 1.toShort()
                }
            }

            on("cast to Int") {
                it("should equal Int<1>") {
                    x.toInt() shouldEqual 1
                }
            }

            on("cast to Long") {
                it("should equal Long<1>") {
                    x.toLong() shouldEqual 1L
                }
            }

            on("cast to Float") {
                it("should equal Float<1.0>") {
                    x.toFloat() shouldEqual 1.0F
                }
            }

            on("cast to Double") {
                it("should equal Double<1.0>") {
                    x.toDouble() shouldEqual 1.0
                }
            }

        }

        given("x of type Byte and ${Byte.MIN_VALUE} <= x <= ${Byte.MAX_VALUE} and y = x.toUByte()"){

            it("should be that y.toByte() == x") {
                for (index in Byte.MIN_VALUE..Byte.MAX_VALUE) {
                    val x = index.toByte()
                    val y = x.toUByte()

                    y.toByte() shouldEqual x
                }
            }

        }
    }

    group("Values caching (fly-weight)") {
        given("(x == y) for ${UByte.MIN_VALUE} <= x = y <= ${UByte.MAX_VALUE}") {

            it("should be that x === y") {
                for (index in UByte.MIN_VALUE_MASK..UByte.MAX_VALUE_MASK) {
                    val x = UByte.valueOf(index)
                    val y = UByte.valueOf(index)

                    x shouldEqual y
                    assertSame(x, y)
                }
            }

        }
    }

    group("Non-overflowing operations") {
        givenNumbers(x = UByte.valueOf(20), y = UByte.valueOf(5)) {

            it("should be that x + y = 25") {
                (x + y) shouldEqual 25
            }

            it("should be that x - y = 15") {
                (x - y) shouldEqual 15
            }

        }

        givenNumbers(x = UByte.valueOf(120), y = UByte.valueOf(64)) {

            it("should be that x + y = 184") {
                (x + y) shouldEqual 184
            }

        }

        givenNumbers(x = Byte.MAX_VALUE.toUByte(), y = Byte.MAX_VALUE){

            it("should be x - y = 0"){
                (x - y) shouldEqual 0
            }

        }

    }

    group("Overflowing operations") {
        givenNumbers(x = UByte.valueOf(5), y = UByte.MAX_VALUE) {

            it("should be that x + y = 5") {
                (x + y) shouldEqual 4
            }

            it("should be that x - y = 6") {
                (x - y) shouldEqual 6
            }

        }

        givenNumbers(x = Byte.MAX_VALUE.toUByte(), y = Byte.MAX_VALUE){

            it("should be x - y = 0"){
                (x - y) shouldEqual 0
            }

            it("should be x + y = 254"){
                (x + y) shouldEqual 254
            }

            it("should be y + x.toByte() = 0"){
                (y + x.toByte()) shouldEqual -2
            }

        }
    }
})