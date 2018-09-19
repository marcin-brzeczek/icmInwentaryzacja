package com.income.icminventory.backstack

import android.content.Context
import com.zhuinden.simplestack.Backstack


/** Static method returning BackStack object from systemService */
object BackstackService {
    val TAG = "BackstackService"

    fun get(context: Context): Backstack = context.getSystemService(TAG) as Backstack
}