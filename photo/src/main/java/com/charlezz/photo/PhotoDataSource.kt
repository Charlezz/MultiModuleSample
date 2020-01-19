package com.charlezz.photo

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import androidx.paging.PositionalDataSource

class PhotoDataSource(val context: Context) : PositionalDataSource<Photo>() {

    private val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    private val projection = null
    private val selection = null
    private val selectionArgs = null
    private val sortOrder = null

    var cursor: Cursor? = null
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Photo>) {
        cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
        cursor?.let {
            val totalCount = it.count
            val photoList = getPhotos(it, 0, params.requestedLoadSize)

            callback.onResult(photoList, 0, totalCount)
        }

    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Photo>) {
        cursor?.let {
            val photoList = getPhotos(it, params.startPosition, params.startPosition + params.loadSize)
            callback.onResult(photoList)
        }
    }

    private fun getPhotos(cursor: Cursor, start: Int, end: Int): ArrayList<Photo> {
        val photoList = ArrayList<Photo>()

        for (index in start until end) {
            if (cursor.moveToNext()) {
                val name =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME))
                val path =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA))
                photoList.add(Photo(name, path))
            } else {
                break
            }
        }
        return photoList
    }

    override fun invalidate() {
        super.invalidate()
        close()

    }
    fun close(){
        cursor?.let {
            if(!it.isClosed){
                it.close()
            }
        }
    }
}