package com.charlezz.multimodulesample

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.charlezz.core.di.ActivityScope
import com.charlezz.multimodulesample.databinding.ActivityMainBinding
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun provideBinding(activity: MainActivity): ActivityMainBinding {
        return DataBindingUtil.setContentView(activity,R.layout.activity_main)
    }
    @Provides
    @ActivityScope
    fun provideViewModelFactory(viewModel:MainViewModel): ViewModelProvider.Factory{
        return object:ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return viewModel as T
            }
        }
    }
}