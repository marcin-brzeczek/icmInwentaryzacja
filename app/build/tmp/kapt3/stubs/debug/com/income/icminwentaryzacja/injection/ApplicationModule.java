package com.income.icminwentaryzacja.injection;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/income/icminwentaryzacja/injection/ApplicationModule;", "", "_application", "Lcom/income/icminwentaryzacja/InitApp;", "(Lcom/income/icminwentaryzacja/InitApp;)V", "provideApplication", "providesDBContext", "Lcom/income/icminwentaryzacja/database/DBContext;", "app_debug"})
@dagger.Module()
public final class ApplicationModule {
    private final com.income.icminwentaryzacja.InitApp _application = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.income.icminwentaryzacja.InitApp provideApplication() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.income.icminwentaryzacja.database.DBContext providesDBContext() {
        return null;
    }
    
    public ApplicationModule(@org.jetbrains.annotations.NotNull()
    com.income.icminwentaryzacja.InitApp _application) {
        super();
    }
}