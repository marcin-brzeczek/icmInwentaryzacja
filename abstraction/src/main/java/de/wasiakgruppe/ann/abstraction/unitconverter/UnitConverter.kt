package de.wasiakgruppe.ann.abstraction.unitconverter

import de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit
import de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit.*
import de.wasiakgruppe.ann.abstraction.domain.RangeMeasure
import de.wasiakgruppe.ann.abstraction.domain.ValueMeasure
import de.wasiakgruppe.ann.abstraction.norms.MeasurementUnitMismatchException

object UnitConverter {
    private val converters: MutableMap<MeasurementUnit, MutableMap<MeasurementUnit, (Float) -> Float>> = HashMap()

    init {
        registerConversion(MGDL, MMOLL, { value -> value / 18f })
        registerConversion(MMOLL, MGDL, { value -> value * 18f })
        registerConversion(CELSIUS, FAHRENHEIT, { value -> (value * 1.8f) - 32f })
        registerConversion(FAHRENHEIT, CELSIUS, { value -> (value - 32f) / 1.8f })
    }

    fun canConvert(from: MeasurementUnit, to: MeasurementUnit) = converters[to]?.contains(from) ?: false

    private fun registerConversion(from: MeasurementUnit, to: MeasurementUnit, conversion: ((Float) -> Float)) {
        if (from == to) throw IllegalStateException("You cannot add conversion to the same unit!")

        val map = converters.getOrPut(to) { mutableMapOf() }
        map[from] = conversion
    }

    fun convert(from: ValueMeasure, toUnit: MeasurementUnit) =
            tryConvert(from, toUnit) ?: throw MeasurementUnitMismatchException("Cannot convert from ${from.unit} to $toUnit")

    fun convert(from: RangeMeasure, toUnit: MeasurementUnit) =
            tryConvert(from, toUnit) ?: throw MeasurementUnitMismatchException("Cannot convert from ${from.unit} to $toUnit")

    fun tryConvert(from: ValueMeasure, toUnit: MeasurementUnit) = if (from.unit == toUnit) from else {
        converters[toUnit]?.let { it[from.unit] }?.let {
            ValueMeasure(it(from.value), toUnit)
        }
    }

    fun tryConvert(from: RangeMeasure, toUnit: MeasurementUnit) = if (from.unit == toUnit) from else {
        converters[toUnit]?.let { it[from.unit] }?.let {
            RangeMeasure(it(from.upper), it(from.lower), toUnit)
        }
    }
}

fun ValueMeasure.convertTo(toUnit: MeasurementUnit) = UnitConverter.convert(this, toUnit)
fun RangeMeasure.convertTo(toUnit: MeasurementUnit) = UnitConverter.convert(this, toUnit)

fun ValueMeasure.canConvertTo(toUnit: MeasurementUnit) = UnitConverter.canConvert(this.unit, toUnit)
fun RangeMeasure.canConvertTo(toUnit: MeasurementUnit) = UnitConverter.canConvert(this.unit, toUnit)

fun ValueMeasure.tryConvertTo(toUnit: MeasurementUnit) = UnitConverter.tryConvert(this, toUnit)
fun RangeMeasure.tryConvertTo(toUnit: MeasurementUnit) = UnitConverter.tryConvert(this, toUnit)