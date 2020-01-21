package com.charlezz.multimodulesample

import com.charlezz.core.di.ActivityScope
import com.charlezz.core.di.CoreComponent
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(dependencies = [CoreComponent::class], modules = [MainModule::class])
interface MainComponent{
    @Component.Factory
    interface Factory{
        fun create(appComponent: CoreComponent,
                   mainModule: MainModule,
                   @BindsInstance activity:MainActivity) : MainComponent
    }
    fun inject(activity:MainActivity)
}