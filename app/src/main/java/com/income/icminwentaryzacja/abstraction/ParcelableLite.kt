package com.income.icminwentaryzacja.abstraction

import android.os.Parcelable

/**
 * This interface is used for every parcelable
 * model in application. It simplifies model creation
 * by overriding unused describeContents() method.
 */
interface ParcelableLite : Parcelable {
    override fun describeContents(): Int = 0
}
