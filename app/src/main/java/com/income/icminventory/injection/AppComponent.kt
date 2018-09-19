package com.income.icminventory.injection

import com.income.icminventory.InitApp
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