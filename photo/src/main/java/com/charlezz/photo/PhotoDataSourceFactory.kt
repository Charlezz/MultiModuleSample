package com.charlezz.photo

import android.content.Context
import androidx.paging.DataSource

class PhotoDataSourceFactory(val context: Context) : DataSource.Factory<Int, Photo>(){
    lateinit var dataSource:PhotoDataSource
    override fun create(): DataSource<Int, Photo> {
        dataSource = PhotoDataSource(context)
        return dataSource
    }
}