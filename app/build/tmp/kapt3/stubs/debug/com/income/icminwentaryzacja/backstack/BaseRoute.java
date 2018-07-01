package com.income.icminwentaryzacja.backstack;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH$J\u0006\u0010\u001e\u001a\u00020\u001dR\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0016\u0010\f\u001a\u00020\n8\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\r\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/income/icminwentaryzacja/backstack/BaseRoute;", "Lcom/income/icminwentaryzacja/abstraction/ParcelableLite;", "()V", "additionalData", "Landroid/os/Bundle;", "fragmentTag", "", "getFragmentTag", "()Ljava/lang/String;", "isBottomNavigationElement", "", "()Z", "isBottomNavigationVisible", "isReturning", "setReturning", "(Z)V", "value", "Landroid/os/Parcelable;", "returnArgument", "getReturnArgument", "()Landroid/os/Parcelable;", "setReturnArgument", "(Landroid/os/Parcelable;)V", "returnRoute", "getReturnRoute", "()Lcom/income/icminwentaryzacja/backstack/BaseRoute;", "setReturnRoute", "(Lcom/income/icminwentaryzacja/backstack/BaseRoute;)V", "createFragment", "Lcom/income/icminwentaryzacja/fragments/abstraction/FragmentBase;", "newFragment", "app_debug"})
public abstract class BaseRoute implements com.income.icminwentaryzacja.abstraction.ParcelableLite {
    private final transient boolean isBottomNavigationElement = false;
    private final transient boolean isBottomNavigationVisible = false;
    private final transient android.os.Bundle additionalData = null;
    @org.jetbrains.annotations.Nullable()
    private com.income.icminwentaryzacja.backstack.BaseRoute returnRoute;
    private boolean isReturning;
    
    public boolean isBottomNavigationElement() {
        return false;
    }
    
    public boolean isBottomNavigationVisible() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFragmentTag() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.income.icminwentaryzacja.backstack.BaseRoute getReturnRoute() {
        return null;
    }
    
    public final void setReturnRoute(@org.jetbrains.annotations.Nullable()
    com.income.icminwentaryzacja.backstack.BaseRoute p0) {
    }
    
    public final boolean isReturning() {
        return false;
    }
    
    public final void setReturning(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.os.Parcelable getReturnArgument() {
        return null;
    }
    
    public final void setReturnArgument(@org.jetbrains.annotations.Nullable()
    android.os.Parcelable value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.income.icminwentaryzacja.fragments.abstraction.FragmentBase newFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.income.icminwentaryzacja.fragments.abstraction.FragmentBase createFragment();
    
    public BaseRoute() {
        super();
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
}