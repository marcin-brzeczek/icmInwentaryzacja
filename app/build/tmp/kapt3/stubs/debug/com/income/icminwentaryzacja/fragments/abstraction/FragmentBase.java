package com.income.icminwentaryzacja.fragments.abstraction;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\b\nH\u0016J\u0006\u0010\u000b\u001a\u00020\u0007J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J!\u0010\u001d\u001a\u00020\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\b\nH\u0016R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/income/icminwentaryzacja/fragments/abstraction/FragmentBase;", "Landroid/app/Fragment;", "Lcom/income/icminwentaryzacja/fragments/abstraction/IOnResumeNotifier;", "()V", "onResumeListeners", "", "Lkotlin/Function1;", "", "addOnResumeListener", "action", "Lkotlin/ExtensionFunctionType;", "navigateBack", "navigateTo", "route", "Lcom/income/icminwentaryzacja/backstack/BaseRoute;", "isReturnigResult", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "removeOnResumeListener", "app_debug"})
public abstract class FragmentBase extends android.app.Fragment implements com.income.icminwentaryzacja.fragments.abstraction.IOnResumeNotifier {
    private java.util.Set<kotlin.jvm.functions.Function1<com.income.icminwentaryzacja.fragments.abstraction.FragmentBase, kotlin.Unit>> onResumeListeners;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void addOnResumeListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.income.icminwentaryzacja.fragments.abstraction.FragmentBase, kotlin.Unit> action) {
    }
    
    @java.lang.Override()
    public void removeOnResumeListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.income.icminwentaryzacja.fragments.abstraction.FragmentBase, kotlin.Unit> action) {
    }
    
    public final void navigateBack() {
    }
    
    public final void navigateTo(@org.jetbrains.annotations.NotNull()
    com.income.icminwentaryzacja.backstack.BaseRoute route, boolean isReturnigResult) {
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater menuInflater) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public FragmentBase() {
        super();
    }
}