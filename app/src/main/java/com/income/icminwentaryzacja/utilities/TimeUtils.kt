package com.income.icminwentaryzacja.utilities

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

const val YEAR_MONTH_DAY_HOUR_MINUTE = "yyyy-MM-dd hh:mm"

val DateTime.todaysDateFormat: String get() = DateTimeFormat.forPattern(YEAR_MONTH_DAY_HOUR_MINUTE).print(this)

val todayDate = DateTime.now().todaysDateFormat