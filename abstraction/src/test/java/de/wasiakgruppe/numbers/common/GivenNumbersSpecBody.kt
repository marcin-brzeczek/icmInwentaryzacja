package de.wasiakgruppe.numbers.common

import org.jetbrains.spek.api.dsl.SpecBody
import org.jetbrains.spek.api.dsl.given

class GivenNumbersSpecBody<out T1, out T2>(private val specBody: SpecBody, val x: T1, val y: T2) : SpecBody by specBody

internal inline fun <T1:Number, T2:Number> SpecBody.givenNumbers(x: T1, y: T2, noinline body: GivenNumbersSpecBody<T1, T2>.() -> Unit)
        = given("x = ${x::class}<$x> and y = ${y::class}<$y>", { body.invoke(GivenNumbersSpecBody(this, x, y)) })
