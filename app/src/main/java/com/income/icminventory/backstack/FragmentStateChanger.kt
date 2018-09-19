package com.income.icminventory.backstack

import android.app.FragmentManager
import android.support.annotation.IdRes
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.zhuinden.simplestack.StateChange
import kotlinx.android.synthetic.main.activity_main.*


/** Class handling fragmentManager and each transition.
 * If you want to add default transaction animation please add it in specified place */
class FragmentStateChanger(private val fragmentManager: FragmentManager, @IdRes private val contentHolderId: Int) {

    fun handleStateChange(stateChange: StateChange) {
        val fragmentTransaction = fragmentManager.beginTransaction().disallowAddToBackStack()

        /** set transaction animations here */
        stateChange.getPreviousState<BaseRoute>().filter {
            fragmentManager.findFragmentByTag(it.fragmentTag) != null
        }.forEach {
            val fragment = fragmentManager.findFragmentByTag(it.fragmentTag)
            if (!stateChange.getNewState<Any>().contains(it)) {
                fragmentTransaction.remove(fragment)
            } else if (!fragment.isDetached) {
                fragmentTransaction.detach(fragment)
            }
        }

        stateChange.getNewState<BaseRoute>().filter { it == stateChange.topNewState<Any>() }.forEach {
            var fragment = fragmentManager.findFragmentByTag(it.fragmentTag)
            if (fragment != null && fragment.isDetached) {
                fragmentTransaction.attach(fragment)
            } else {
                fragment = it.newFragment()
                fragmentTransaction.add(contentHolderId, fragment, it.fragmentTag)
            }
//            (fragment as FragmentBase).addOnResumeListener { activity.main_container?.onFragmentChange(it) }
        }

        stateChange.getNewState<BaseRoute>().filter {
            val fragment = fragmentManager.findFragmentByTag(it.fragmentTag)
            fragment != null && !fragment.isDetached
        }.forEach {
            fragmentTransaction.detach(fragmentManager.findFragmentByTag(it.fragmentTag))
        }
        fragmentTransaction.commit()
    }
}