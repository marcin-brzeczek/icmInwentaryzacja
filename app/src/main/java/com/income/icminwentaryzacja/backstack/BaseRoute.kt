package com.income.icminwentaryzacja.backstack

import android.os.Bundle
import android.os.Parcelable
import com.income.icminwentaryzacja.abstraction.ParcelableLite
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase


const val ROUTE_ARGUMENTS_KEY = "KEY"
const val ROUTE_RETURN_ARGUMENTS_KEY = "RETURN_ARGUMENTS_KEY"

/** BaseRoute is a "route" to specific fragment. It is used as key for our custom BackStack implementation.
 * BaseRoute should have all data that is required to be passed to the Fragment.
 * You can later retrieve fragment specific route in fragment to gain access to the data. */
abstract class BaseRoute : ParcelableLite {

    /** Property used to distinguish each fragment in an route */
    val fragmentTag get() = toString()

    @field:Transient
    private val additionalData = Bundle()

    var returnRoute: BaseRoute? = null

    var isReturning = false

    var returnArgument: Parcelable?
        get() = additionalData.getParcelable(ROUTE_RETURN_ARGUMENTS_KEY)
        set(value) { value?.apply { additionalData.putParcelable(ROUTE_RETURN_ARGUMENTS_KEY, value) } }

    /** Handles creation of new fragment */
    fun newFragment(): FragmentBase {
        val fragment = createFragment()
        val bundle = fragment.arguments ?: Bundle()
        bundle.putParcelable(ROUTE_ARGUMENTS_KEY, this)
        fragment.arguments = bundle
        return fragment
    }

    /** Each custom route should return fragment that it leads to. */
    protected abstract fun createFragment(): FragmentBase
}