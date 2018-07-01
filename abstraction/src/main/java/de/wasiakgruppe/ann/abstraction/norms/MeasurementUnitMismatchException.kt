package de.wasiakgruppe.ann.abstraction.norms

class MeasurementUnitMismatchException : Exception {
    constructor() : super("Wrong measurement unit given!")
    constructor(message: String) : super(message)
}
