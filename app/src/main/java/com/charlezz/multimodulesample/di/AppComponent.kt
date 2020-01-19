package com.charlezz.multimodulesample.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{

    fun getApplication():Application

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application):AppComponent
    }

}