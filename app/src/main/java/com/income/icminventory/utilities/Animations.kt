package com.income.icminventory.utilities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

const val DEFAULT_MIN_APLHA_OPACITY = 0F
const val DEFAULT_MAX_OPACITY = 1F

fun fadeIn(view: View, duration: Long, toAlpha: Float = DEFAULT_MAX_OPACITY) {
    view.apply {
        alpha = DEFAULT_MIN_APLHA_OPACITY
        visibility = View.VISIBLE
        animate()
            .alpha(toAlpha)
            .setDuration(duration)
            .setListener(null)
    }
}

fun fadeOut(view: View, duration: Long, toAlpha: Float = DEFAULT_MIN_APLHA_OPACITY) {
    view.apply {
        alpha = DEFAULT_MAX_OPACITY
        visibility = View.VISIBLE
        animate()
            .alpha(toAlpha)
            .setDuration(duration)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    visibility = View.GONE
                }
            })
    }
}