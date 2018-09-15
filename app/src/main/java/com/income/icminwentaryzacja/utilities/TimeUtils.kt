package com.income.icminwentaryzacja.utilities

import android.content.Context
import android.text.format.DateFormat
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

const val YEAR_MONTH_DAY_HOUR_MINUTE_US = "yyyy-MM-dd hh_mm_a"
const val YEAR_MONTH_DAY_HOUR_MINUTE_PL = "yyyy-MM-dd HH_mm"

fun DateTime.todaysDateFormat(context:Context) = (if (DateFormat.is24HourFormat(context)) DateTimeFormat.forPattern(YEAR_MONTH_DAY_HOUR_MINUTE_PL).print(this.plusHours(2)) else DateTimeFormat.forPattern(YEAR_MONTH_DAY_HOUR_MINUTE_US).print(this.plusHours(2)))!!

fun todayDate(context: Context) = DateTime.now().todaysDateFormat(context)
