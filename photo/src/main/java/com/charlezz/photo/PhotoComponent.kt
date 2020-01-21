package com.charlezz.photo

import com.charlezz.multimodulesample.app.dep.AppDependencies
import com.charlezz.multimodulesample.di.ActivityScope
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [PhotoModule::class], dependencies = [AppDependencies::class])
interface PhotoComponent {

    fun inject(photoActivity: PhotoActivity)

    @Component.Factory
    interface Factory {
        fun create(
            appDependencies: AppDependencies,
            @BindsInstance photoActivity: PhotoActivity
        ): PhotoComponent
    }
}