package de.wasiakgruppe.ann.abstraction.norms

import de.wasiakgruppe.ann.abstraction.domain.Gender
import org.joda.time.DateTime

/** This interface describes information about the person */
interface IPersonInfo {

    /** Gender of the person */
    val gender: Gender

    /** Birth date of the person */
    val birthDate: DateTime?

    /** Empty person info object for testing purposes */
    companion object {
        object EmptyPersonInfo : IPersonInfo {
            override val gender = Gender.UNKNOWN
            override val birthDate = null
        }
    }
}