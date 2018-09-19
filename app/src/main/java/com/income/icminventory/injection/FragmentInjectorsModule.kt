package com.income.icminventory.injection

import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.information.InfoFragment
import com.income.icminventory.fragments.location.ChooseLocationFragment
import com.income.icminventory.fragments.location.NewLocationFragment
import com.income.icminventory.fragments.login.LoginFragment
import com.income.icminventory.fragments.new_position.NewItemFragment
import com.income.icminventory.fragments.positions_list.empty_list.EmptyListFragment
import com.income.icminventory.fragments.positions_list.scanned_list.ScannedListFragment
import com.income.icminventory.fragments.report.ReportFragment
import com.income.icminventory.fragments.scan_positions.ScanPositionsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

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
    @ContributesAndroidInjector internal abstract fun contributeNewLocationFragment(): NewLocationFragment
    @ContributesAndroidInjector internal abstract fun contributeInfoFragment(): InfoFragment
}