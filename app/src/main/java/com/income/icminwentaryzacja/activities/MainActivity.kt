package com.income.icminwentaryzacja.activities

import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.activities.abstraction.ActivityBase
import com.income.icminwentaryzacja.fragments.report.ReportRoute


class MainActivity : ActivityBase() {

    override val layoutId = R.layout.activity_main
    override val startRoute get() = ReportRoute()
}