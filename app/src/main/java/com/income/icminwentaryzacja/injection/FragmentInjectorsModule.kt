package com.income.icminwentaryzacja.injection

import com.income.icminwentaryzacja.fragments.login.LoginFragment
import com.income.icminwentaryzacja.fragments.positions_list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.report.ReportFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsFragment


@Module
internal abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector
    internal abstract fun contributeFragmentGeneralBase(): FragmentBase


    @ContributesAndroidInjector internal abstract fun contributeLoginFragment(): LoginFragment
    @ContributesAndroidInjector internal abstract fun contributeLoginInputFragment(): ListFragment
    @ContributesAndroidInjector internal abstract fun contributeReportFragment(): ReportFragment
    @ContributesAndroidInjector internal abstract fun contributeScanPositionsFragment(): ScanPositionsFragment

}