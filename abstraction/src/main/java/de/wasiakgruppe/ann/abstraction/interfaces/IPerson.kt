package de.wasiakgruppe.ann.abstraction.interfaces

interface IPerson : IUniqueEntry {
    val firstName: String
    val lastName: String
    val phoneNumber: String?
    val email: String?
}