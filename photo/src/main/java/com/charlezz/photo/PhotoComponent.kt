package com.charlezz.photo

import com.charlezz.core.di.ActivityScope
import com.charlezz.core.di.CoreComponent
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [PhotoModule::class], dependencies =[CoreComponent::class] )
interface PhotoComponent {

    fun inject(photoActivity: PhotoActivity)

    @Component.Factory
    interface Factory {
        fun create(appComponent: CoreComponent,
                   photoModule: PhotoModule,
                   @BindsInstance photoActivity:PhotoActivity): PhotoComponent
    }
}