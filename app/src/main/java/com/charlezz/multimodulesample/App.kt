package com.charlezz.multimodulesample

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.charlezz.multimodulesample.di.AppComponent
import com.charlezz.multimodulesample.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent:AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}