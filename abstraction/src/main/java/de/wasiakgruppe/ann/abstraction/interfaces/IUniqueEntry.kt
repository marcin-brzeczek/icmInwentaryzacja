package de.wasiakgruppe.ann.abstraction.interfaces

import java.util.*

/** Interface describes models that need to be distinct. */
interface IUniqueEntry {

    /** UUID used to distinguish models */
    val id : UUID
}