package com.income.icminwentaryzacja.injection

import com.income.icminwentaryzacja.InitApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityInjectorsModule::class,
        FragmentInjectorsModule::class))
interface AppComponent : AndroidInjector<InitApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<InitApp>() {
        abstract fun setApplicationModule(module: ApplicationModule)
    }

}