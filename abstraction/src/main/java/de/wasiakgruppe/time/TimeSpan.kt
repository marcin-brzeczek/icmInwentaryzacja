package de.wasiakgruppe.time

import java.util.concurrent.TimeUnit

@Suppress("NOTHING_TO_INLINE", "UNUSED")
data class TimeSpan(val duration: Long, val unit: TimeUnit = TimeUnit.MILLISECONDS){
    companion object {
        inline fun fromMilliseconds(duration: Long) = TimeSpan(duration, TimeUnit.MILLISECONDS)
        inline fun fromSeconds(duration: Long) = TimeSpan(duration, TimeUnit.SECONDS)
        inline fun fromMinutes(duration: Long) = TimeSpan(duration, TimeUnit.MINUTES)
        inline fun fromHours(duration: Long) = TimeSpan(duration, TimeUnit.HOURS)
        inline fun fromDays(duration: Long) = TimeSpan(duration, TimeUnit.DAYS)
    }
}