package com.sriram.mocknbc.ui.model

sealed class ItemGroup(
    open val image: String? = "",
    open val labelBadge: String? = "",
    open val subtitle: String? = "",
    open val tagline: String? = "",
    open val title: String? = "",
    open val type: ItemGroupType?,
) {
    data class LIVE(
        override val image: String?,
        override val labelBadge: String?,
        override val subtitle: String?,
        override val tagline: String?,
        override val title: String?,
        override val type: ItemGroupType?,
    ) : ItemGroup(type = ItemGroupType.Live)

    data class EPISODE(
        override val image: String?,
        override val labelBadge: String?,
        override val subtitle: String?,
        override val tagline: String?,
        override val title: String?,
        override val type: ItemGroupType?,
    ) : ItemGroup(type = ItemGroupType.Episode)

    data class SHOW(
        override val image: String?,
        override val labelBadge: String?,
        override val subtitle: String?,
        override val tagline: String?,
        override val title: String?,
        override val type: ItemGroupType?,
    ) : ItemGroup(type = ItemGroupType.Show)
}

enum class ItemGroupType {
    Live,
    Episode,
    Show,
}
