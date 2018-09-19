package com.income.icminventory.fragments.abstraction

/**
 * Interface used for FragmentBase. User can add and remove
 * onResumeListeners to the fragment.
 */
interface IOnResumeNotifier {
    fun addOnResumeListener(action: FragmentBase.() -> Unit)
    fun removeOnResumeListener(action: FragmentBase.() -> Unit)
}