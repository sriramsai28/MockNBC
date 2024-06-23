package com.sriram.mocknbc.ui.model

import com.sriram.mocknbc.data.model.Shelve

data class Carousel(
    val title: String?,
    val content: List<ItemGroup>?,
)

fun List<Shelve>.toCarousel(): List<Carousel> {
    val carousel = mutableListOf<Carousel>()
    forEach {
        carousel.add(
            Carousel(
                title = it.title,
                content = it.items?.toItemGroup(),
            ),
        )
    }
    return carousel
}
