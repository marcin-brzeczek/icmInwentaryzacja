package com.income.icminwentaryzacja.injection

import com.income.icminwentaryzacja.InitApp
import com.income.icminwentaryzacja.database.DBContext
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