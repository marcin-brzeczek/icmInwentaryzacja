package de.wasiakgruppe.ann.abstraction.interfaces

import de.wasiakgruppe.ann.abstraction.domain.Measure
import de.wasiakgruppe.ann.abstraction.domain.MeasurementType
import org.joda.time.DateTime

/** This interface describes measurement in our application.
 *
 * @param <T> every measurement contains measure inside.
 * It could be ValueMeasure or RangeMeasure, so measure type must be defined beforehand.
 */
interface IMeasurement<out T : Measure> : IUniqueEntry {

    /** Timestamp which defines when measurement was taken */
    val time: DateTime

    /** Flag which defines if measurement was created manually, or sent by device */
    val isManual: Boolean

    /** Actual measure that contains value and measurement unit */
    val value: T

    /** Type of the measurement */
    val type: MeasurementType

    /** Device which sent the measurement. Could be null if measurement was created manually */
    val device: IDevice?
}