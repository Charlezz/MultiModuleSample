package com.charlezz.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

abstract class PagedSingleItemAdapter<T, VDB : ViewDataBinding>(val bindingResId:Int, diffCallback: DiffUtil.ItemCallback<T>) : PagedListAdapter<T, ViewBindingHolder<VDB>>(diffCallback) {
    abstract fun getViewHolderLayoutId():Int

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingHolder<VDB> {
        val binding = DataBindingUtil.inflate<VDB>(
                LayoutInflater.from(parent.context),
                getViewHolderLayoutId(),
                parent,
                false)

        return object: ViewBindingHolder<VDB>(binding) {}
    }

    override fun onBindViewHolder(holder: ViewBindingHolder<VDB>, position: Int) {
        holder.binding.setVariable(bindingResId, getItem(position))
        holder.binding.executePendingBindings()
    }
}
