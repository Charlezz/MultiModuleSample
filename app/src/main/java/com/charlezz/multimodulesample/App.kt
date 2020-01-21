package com.charlezz.multimodulesample

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.charlezz.core.di.CoreComponent
import com.charlezz.core.di.DaggerCoreComponent

class App : Application() {

    private val coreComponent: CoreComponent by lazy{
        DaggerCoreComponent.factory().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object{
        @JvmStatic
        fun coreComponent(context:Context) = (context.applicationContext as App).coreComponent
    }

}

fun Activity.coreComponent() = App.coreComponent(this)