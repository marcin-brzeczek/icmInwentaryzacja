package de.wasiakgruppe.ann.abstraction.norms

import de.wasiakgruppe.ann.abstraction.domain.Measure
import de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit

abstract class NormBase<in M : Measure> : INorm<M> {
    abstract val acceptableUnits: Set<MeasurementUnit>

    protected abstract fun validate(measure: M, profile: IPersonInfo): Boolean

    override final fun acceptsUnit(unit: MeasurementUnit) = acceptableUnits.contains(unit)

    override final fun isValid(measure: M, profile: IPersonInfo, throwExceptionOnUnitMismatch: Boolean): Boolean {
        return if (!acceptsUnit(measure.unit)) {
            if (throwExceptionOnUnitMismatch) throw MeasurementUnitMismatchException()
            else return false
        } else validate(measure, profile)
    }
}