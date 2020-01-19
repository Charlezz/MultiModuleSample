package com.charlezz.core.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@Suppress("UNCHECKED_CAST")
@BindingAdapter("pagedList")
fun <T> submitList(recyclerView: androidx.recyclerview.widget.RecyclerView, pageList: PagedList<T>?) {
    pageList?.let {
        val adapter = recyclerView.adapter as PagedListAdapter<T, *>
        adapter.submitList(pageList)
    }
}

@BindingAdapter("isVisible")
fun setVisibility(view: View, isVisible: Boolean){
    if(isVisible){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter("image")
fun setImage(imageView: ImageView, path:String?){
    path?.let {
        Glide.with(imageView).load(it).transition(DrawableTransitionOptions.withCrossFade()).into(imageView)
    }
}