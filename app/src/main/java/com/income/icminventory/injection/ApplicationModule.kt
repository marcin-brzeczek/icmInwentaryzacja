package com.income.icminventory.injection

import com.income.icminventory.InitApp
import com.income.icminventory.database.DBContext
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class ApplicationModule(private val _application: InitApp) {

    @Provides
    @Singleton
    fun provideApplication(): InitApp = _application


    @Provides
    @Singleton
    fun providesDBContext(): DBContext = DBContext()
}