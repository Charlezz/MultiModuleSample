package com.charlezz.photo

import com.charlezz.multimodulesample.di.ActivityScope
import com.charlezz.multimodulesample.di.AppComponent
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [PhotoModule::class], dependencies =[AppComponent::class] )
interface PhotoComponent{

    fun inject(photoActivity: PhotoActivity)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent,
                   photoModule: PhotoModule,
                   @BindsInstance photoActivity:PhotoActivity): PhotoComponent
    }
}