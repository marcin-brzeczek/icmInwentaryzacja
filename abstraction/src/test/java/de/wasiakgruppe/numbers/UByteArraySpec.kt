package de.wasiakgruppe.numbers

import de.wasiakgruppe.numbers.common.shouldContentEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

object UByteArraySpec : Spek({

    given("array of bytes x = {1,2,3,4}") {
        val x = byteArrayOf(1, 2, 3, 4)

        it("should equal (by content) to y = ubyteArrayOf(1,2,3,4)") {
            val y = ubyteArrayOf(1, 2, 3, 4)
            y.raw shouldContentEqual x
        }

        it("should equal (by content) to y = ubyteArrayOf(ubyte(1),ubyte(2),ubyte(3),ubyte(4))") {
            val y = ubyteArrayOf(ubyte(1), ubyte(2), ubyte(3), ubyte(4))
            y.raw shouldContentEqual x
        }

    }

})