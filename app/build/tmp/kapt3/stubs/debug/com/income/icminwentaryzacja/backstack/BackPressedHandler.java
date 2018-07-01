package com.income.icminwentaryzacja.backstack;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/income/icminwentaryzacja/backstack/BackPressedHandler;", "Lcom/zhuinden/simplestack/Backstack$CompletionListener;", "backStackDelegate", "Lcom/zhuinden/simplestack/BackstackDelegate;", "(Lcom/zhuinden/simplestack/BackstackDelegate;)V", "isFinalBackPress", "", "backstackHistoryChange", "", "lastElementRoute", "Lcom/income/icminwentaryzacja/backstack/BaseRoute;", "handleBackPressed", "context", "Landroid/content/Context;", "resetFinalExit", "shouldExit", "stateChangeCompleted", "stateChange", "Lcom/zhuinden/simplestack/StateChange;", "app_debug"})
public final class BackPressedHandler implements com.zhuinden.simplestack.Backstack.CompletionListener {
    private boolean isFinalBackPress;
    private final com.zhuinden.simplestack.BackstackDelegate backStackDelegate = null;
    
    @java.lang.Override()
    public void stateChangeCompleted(@org.jetbrains.annotations.NotNull()
    com.zhuinden.simplestack.StateChange stateChange) {
    }
    
    private final void resetFinalExit() {
    }
    
    private final boolean shouldExit(android.content.Context context) {
        return false;
    }
    
    public final boolean handleBackPressed(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    private final void backstackHistoryChange(com.income.icminwentaryzacja.backstack.BaseRoute lastElementRoute) {
    }
    
    public BackPressedHandler(@org.jetbrains.annotations.NotNull()
    com.zhuinden.simplestack.BackstackDelegate backStackDelegate) {
        super();
    }
}