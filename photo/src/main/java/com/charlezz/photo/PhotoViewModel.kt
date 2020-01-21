package com.charlezz.photo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.LivePagedListBuilder
import com.charlezz.core.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class PhotoViewModel @Inject constructor(app: Application): AndroidViewModel(app){
    val dataSourceFactory = PhotoDataSourceFactory(app)
    val photos = LivePagedListBuilder(dataSourceFactory, 50).build()

    override fun onCleared() {
        super.onCleared()
        dataSourceFactory.dataSource.close()
    }
}