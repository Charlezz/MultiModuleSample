package com.charlezz.core.di

import android.app.Application
import com.charlezz.multimodulesample.app.dep.AppDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface CoreComponent : AppDependencies {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): CoreComponent
    }

}