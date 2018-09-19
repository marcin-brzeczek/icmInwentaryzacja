package com.income.icminventory

import com.income.icminventory.injection.ApplicationModule
import com.income.icminventory.injection.DaggerAppComponent
import com.raizlabs.android.dbflow.config.FlowManager
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasActivityInjector
import timber.log.Timber

class InitApp : DaggerApplication(), HasActivityInjector {
    private val _applicationInjector by lazy {
        DaggerAppComponent.builder().let {
            it.seedInstance(this)
            it.setApplicationModule(ApplicationModule(this))
            it.build()
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = _applicationInjector

    /**
     * FlowManager.init() is responsible for starting DBFlow database
     */
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        FlowManager.init(applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
        FlowManager.destroy()
    }


}