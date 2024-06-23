package com.sriram.mocknbc.ui.model

import com.sriram.mocknbc.data.model.Item

fun List<Item>.toItemGroup(): List<ItemGroup> {
    val itemGroups = mutableListOf<ItemGroup>()
    this.forEach {
        when (it.type) {
            ItemGroupType.Live.toString() -> {
                itemGroups.add(it.toItemGroup(ItemGroupType.Live))
            }
            ItemGroupType.Episode.name -> {
                itemGroups.add(it.toItemGroup(ItemGroupType.Episode))
            }
            else -> {
                itemGroups.add(it.toItemGroup(ItemGroupType.Show))
            }
        }
    }
    return itemGroups
}

fun Item.toItemGroup(type: ItemGroupType): ItemGroup {
    when (type) {
        ItemGroupType.Live -> return ItemGroup.LIVE(
            image = image,
            labelBadge = labelBadge,
            subtitle = subtitle,
            tagline = tagline,
            title = title,
            type = ItemGroupType.Live,
        )
        ItemGroupType.Episode -> return ItemGroup.EPISODE(
            image = image,
            labelBadge = labelBadge,
            subtitle = subtitle,
            tagline = tagline,
            title = title,
            type = ItemGroupType.Episode,
        )
        ItemGroupType.Show -> return ItemGroup.SHOW(
            image = image,
            labelBadge = labelBadge,
            subtitle = subtitle,
            tagline = tagline,
            title = title,
            type = ItemGroupType.Show,
        )
    }
}
