package com.income.icminwentaryzacja.fragments.abstraction;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\b\u0007H&J!\u0010\b\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\b\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/income/icminwentaryzacja/fragments/abstraction/IOnResumeNotifier;", "", "addOnResumeListener", "", "action", "Lkotlin/Function1;", "Lcom/income/icminwentaryzacja/fragments/abstraction/FragmentBase;", "Lkotlin/ExtensionFunctionType;", "removeOnResumeListener", "app_debug"})
public abstract interface IOnResumeNotifier {
    
    public abstract void addOnResumeListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.income.icminwentaryzacja.fragments.abstraction.FragmentBase, kotlin.Unit> action);
    
    public abstract void removeOnResumeListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.income.icminwentaryzacja.fragments.abstraction.FragmentBase, kotlin.Unit> action);
}