package com.charlezz.photo

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.charlezz.multimodulesample.di.ActivityScope
import com.charlezz.photo.databinding.ActivityPhotoBinding
import dagger.Module
import dagger.Provides

@Module
class PhotoModule{

    @Provides
    @ActivityScope
    fun provideActivityPhotoBinding(activity: PhotoActivity): ActivityPhotoBinding {
        return DataBindingUtil.setContentView(activity, R.layout.activity_photo)
    }

    @Provides
    @ActivityScope
    fun provideViewModelFactory(viewModel:PhotoViewModel): ViewModelProvider.Factory{
        return object: ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return viewModel as T
            }
        }
    }
}
