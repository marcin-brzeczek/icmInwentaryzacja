package de.wasiakgruppe.ann.abstraction.domain

import android.os.Parcel
import de.wasiakgruppe.ann.abstraction.interfaces.AnnParcelableLite
import paperparcel.PaperParcel

sealed class Measure {
    abstract val unit: MeasurementUnit
}

@PaperParcel
data class ValueMeasure(val value: Float, override val unit: MeasurementUnit) : Measure(), AnnParcelableLite {
    companion object {
        @JvmField
        val EMPTY = ValueMeasure(0f, MeasurementUnit.UNKNOWN)

        @JvmField
        val CREATOR = PaperParcelValueMeasure.CREATOR
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelValueMeasure.writeToParcel(this, dest, flags)
    }

    override fun toString() = String.format("%.2f %S", value, unit.displayName)
}

@PaperParcel
data class RangeMeasure(val upper: Float, val lower: Float, override val unit: MeasurementUnit) : Measure(), AnnParcelableLite {
    companion object {
        @JvmField
        val EMPTY = RangeMeasure(0f, 0f, MeasurementUnit.UNKNOWN)

        @JvmField
        val CREATOR = PaperParcelRangeMeasure.CREATOR
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelRangeMeasure.writeToParcel(this, dest, flags)
    }

    override fun toString() = String.format("%.2f/%.2f %S", upper, lower, unit.displayName)
}