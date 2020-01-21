package com.charlezz.multimodulesample

import com.charlezz.multimodulesample.app.dep.AppDependencies
import com.charlezz.multimodulesample.di.ActivityScope
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(dependencies = [AppDependencies::class], modules = [MainModule::class])
interface MainComponent{
    @Component.Factory
    interface Factory{
        fun create(appDependencies: AppDependencies,
                   mainModule: MainModule,
                   @BindsInstance activity:MainActivity) : MainComponent
    }
    fun inject(activity:MainActivity)
}