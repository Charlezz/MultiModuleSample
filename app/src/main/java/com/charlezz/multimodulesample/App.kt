package com.charlezz.multimodulesample

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.charlezz.core.di.CoreComponent
import com.charlezz.core.di.DaggerCoreComponent
import com.charlezz.multimodulesample.app.dep.AppDependencies
import com.charlezz.multimodulesample.app.dep.AppDependenciesProvider

class App : Application(), AppDependenciesProvider {

    private val coreComponent: CoreComponent by lazy{
        DaggerCoreComponent.factory().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun appDependencies(): AppDependencies = coreComponent

}