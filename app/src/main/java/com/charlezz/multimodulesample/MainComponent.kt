package com.charlezz.multimodulesample

import com.charlezz.multimodulesample.di.ActivityScope
import com.charlezz.multimodulesample.di.AppComponent
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MainModule::class])
interface MainComponent{
    @Component.Factory
    interface Factory{
        fun create(appComponent: AppComponent,
                   mainModule: MainModule,
                   @BindsInstance activity:MainActivity) : MainComponent
    }
    fun inject(activity:MainActivity)
}