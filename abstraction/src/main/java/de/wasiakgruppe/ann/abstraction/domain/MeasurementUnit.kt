package de.wasiakgruppe.ann.abstraction.domain

enum class MeasurementUnit(val displayName: String) {
    CELSIUS("\u00B0C"),
    FAHRENHEIT("\u00B0F"),
    MMOLL("mmol/l"),
    MGDL("mg/dl"),
    MMHG("mm Hg"),
    BPM("bpm"),
    KG("kg"),
    LBS("lbs"),
    UNKNOWN("")
}