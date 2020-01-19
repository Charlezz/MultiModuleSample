package com.charlezz.core.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class ViewBindingHolder<VDB : ViewDataBinding>(val binding: VDB) : RecyclerView.ViewHolder(binding.root)