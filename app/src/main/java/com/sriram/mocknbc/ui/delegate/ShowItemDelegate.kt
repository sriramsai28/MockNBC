package com.sriram.mocknbc.ui.delegate

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.sriram.mocknbc.databinding.ShowItemBinding
import com.sriram.mocknbc.ui.model.ItemGroup

fun showDelegate() =
    adapterDelegateViewBinding<ItemGroup.SHOW, ItemGroup, ShowItemBinding>(
        { layoutInflater, root -> ShowItemBinding.inflate(layoutInflater, root, false) },
        on = { item: ItemGroup, items: List<ItemGroup>, position: Int ->
            item is ItemGroup.SHOW
        },
    ) {
        bind {
            with(item) {
                title?.let { titleText ->
                    binding.title.text = titleText
                }
                subtitle?.let { subText ->
                    binding.subTitle.text = subText
                }
                image?.let { imageUrl ->
                    Glide.with(binding.poster).load(imageUrl).into(binding.poster)
                }
            }
        }
    }
