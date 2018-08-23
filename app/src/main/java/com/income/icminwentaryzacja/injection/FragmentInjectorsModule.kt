package com.income.icminwentaryzacja.injection

import com.income.icminwentaryzacja.fragments.login.LoginFragment
import com.income.icminwentaryzacja.fragments.positions_list.empty_list.EmptyListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.choose_location.ChooseLocationFragment
import com.income.icminwentaryzacja.fragments.new_position.NewItemFragment
import com.income.icminwentaryzacja.fragments.positions_list.scanned_list.ScannedListFragment
import com.income.icminwentaryzacja.fragments.report.ReportFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsFragment

@Module
internal abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector
    internal abstract fun contributeFragmentGeneralBase(): FragmentBase

    @ContributesAndroidInjector internal abstract fun contributeLoginFragment(): LoginFragment
    @ContributesAndroidInjector internal abstract fun contributeEmptyListFragment(): EmptyListFragment
    @ContributesAndroidInjector internal abstract fun contributeScannedListFragment(): ScannedListFragment
    @ContributesAndroidInjector internal abstract fun contributeReportFragment(): ReportFragment
    @ContributesAndroidInjector internal abstract fun contributeScanPositionsFragment(): ScanPositionsFragment
    @ContributesAndroidInjector internal abstract fun contributeNewItemFragment(): NewItemFragment
    @ContributesAndroidInjector internal abstract fun contributeChooseLocationFragment(): ChooseLocationFragment
}