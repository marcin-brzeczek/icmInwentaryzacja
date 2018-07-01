package com.income.icminwentaryzacja.injection;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/income/icminwentaryzacja/injection/AppComponent;", "Ldagger/android/AndroidInjector;", "Lcom/income/icminwentaryzacja/InitApp;", "Builder", "app_debug"})
@dagger.Component(modules = {dagger.android.AndroidInjectionModule.class, com.income.icminwentaryzacja.injection.ApplicationModule.class, com.income.icminwentaryzacja.injection.ActivityInjectorsModule.class, com.income.icminwentaryzacja.injection.FragmentInjectorsModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent extends dagger.android.AndroidInjector<com.income.icminwentaryzacja.InitApp> {
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/income/icminwentaryzacja/injection/AppComponent$Builder;", "Ldagger/android/AndroidInjector$Builder;", "Lcom/income/icminwentaryzacja/InitApp;", "()V", "setApplicationModule", "", "module", "Lcom/income/icminwentaryzacja/injection/ApplicationModule;", "app_debug"})
    @dagger.Component.Builder()
    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<com.income.icminwentaryzacja.InitApp> {
        
        public abstract void setApplicationModule(@org.jetbrains.annotations.NotNull()
        com.income.icminwentaryzacja.injection.ApplicationModule module);
        
        public Builder() {
            super();
        }
    }
}