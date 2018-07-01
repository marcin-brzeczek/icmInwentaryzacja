package de.wasiakgruppe.ann.abstraction.norms

import de.wasiakgruppe.ann.abstraction.domain.Measure
import de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit

/**
 * Norm that can validate a measure.
 *
 * @param <in M : Measure> the type of measure used for this norm
 */
interface INorm<in M : Measure> {

    /** @return true if this norm accepts given measurement unit */
    fun acceptsUnit(unit: MeasurementUnit): Boolean

    /** @return true if given measure is valid */
    fun isValid(measure: M, profile: IPersonInfo, throwExceptionOnUnitMismatch: Boolean): Boolean
}