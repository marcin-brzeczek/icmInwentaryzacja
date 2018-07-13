package com.income.icminwentaryzacja.fragments.report

import android.os.Parcel
import com.income.icminwentaryzacja.backstack.BaseRoute
import paperparcel.PaperParcel

@PaperParcel
data class ReportRoute(val tag: String = ReportRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = ReportFragment()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        PaperParcelReportRoute.writeToParcel(this, parcel, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelReportRoute.CREATOR
    }
}