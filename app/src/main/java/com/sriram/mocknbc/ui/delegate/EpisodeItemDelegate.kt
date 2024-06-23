package com.sriram.mocknbc.ui.delegate

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.sriram.mocknbc.databinding.EpisodeItemBinding
import com.sriram.mocknbc.ui.model.ItemGroup

fun episodeDelegate() =
    adapterDelegateViewBinding<ItemGroup.EPISODE, ItemGroup, EpisodeItemBinding>(
        { layoutInflater, root -> EpisodeItemBinding.inflate(layoutInflater, root, false) },
        on = { item: ItemGroup, items: List<ItemGroup>, position: Int ->
            item is ItemGroup.EPISODE
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
                labelBadge?.let { labelText ->
                    binding.label.isVisible = true
                    binding.label.text = labelText
                }
            }
        }
    }
