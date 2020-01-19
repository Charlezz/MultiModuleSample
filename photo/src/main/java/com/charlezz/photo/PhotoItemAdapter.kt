package com.charlezz.photo

import androidx.recyclerview.widget.DiffUtil
import com.charlezz.core.ui.PagedSingleItemAdapter
import com.charlezz.multimodulesample.di.ActivityScope
import com.charlezz.photo.databinding.ViewPhotoBinding
import javax.inject.Inject

@ActivityScope
class PhotoItemAdapter @Inject constructor() : PagedSingleItemAdapter<Photo, ViewPhotoBinding>(BR.photo, diffCallback){

    override fun getViewHolderLayoutId(): Int = R.layout.view_photo

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areContentsTheSame(oldItem: Photo, newItem: Photo)= true
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo) = oldItem.path == newItem.path
        }
    }

}