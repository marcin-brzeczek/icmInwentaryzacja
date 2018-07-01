package de.wasiakgruppe.ann.abstraction.interfaces

import org.joda.time.DateTime

interface IDevice : IUniqueEntry {
    val name: String
    val mac: String
    val hardwareVersion: String?
    val softwareVersion: String?
    val registrationDate: DateTime
}