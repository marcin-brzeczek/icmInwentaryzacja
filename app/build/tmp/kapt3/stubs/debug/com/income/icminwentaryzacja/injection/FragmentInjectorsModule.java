package com.income.icminwentaryzacja.injection;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H!\u00a2\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0007H!\u00a2\u0006\u0002\b\bJ\r\u0010\t\u001a\u00020\nH!\u00a2\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH!\u00a2\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u0010H!\u00a2\u0006\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/income/icminwentaryzacja/injection/FragmentInjectorsModule;", "", "()V", "contributeFragmentGeneralBase", "Lcom/income/icminwentaryzacja/fragments/abstraction/FragmentBase;", "contributeFragmentGeneralBase$app_debug", "contributeLoginFragment", "Lcom/income/icminwentaryzacja/fragments/login/LoginFragment;", "contributeLoginFragment$app_debug", "contributeLoginInputFragment", "Lcom/income/icminwentaryzacja/fragments/positions_list/ListFragment;", "contributeLoginInputFragment$app_debug", "contributeReportFragment", "Lcom/income/icminwentaryzacja/fragments/report/ReportFragment;", "contributeReportFragment$app_debug", "contributeScanPositionsFragment", "Lcom/income/icminwentaryzacja/fragments/scan_positions/ScanPositionsFragment;", "contributeScanPositionsFragment$app_debug", "app_debug"})
@dagger.Module()
public abstract class FragmentInjectorsModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.income.icminwentaryzacja.fragments.abstraction.FragmentBase contributeFragmentGeneralBase$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.income.icminwentaryzacja.fragments.login.LoginFragment contributeLoginFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.income.icminwentaryzacja.fragments.positions_list.ListFragment contributeLoginInputFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.income.icminwentaryzacja.fragments.report.ReportFragment contributeReportFragment$app_debug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsFragment contributeScanPositionsFragment$app_debug();
    
    public FragmentInjectorsModule() {
        super();
    }
}