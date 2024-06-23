package com.sriram.mocknbc.data.model

data class HomeScreenContent(
    val page: String?,
    val shelves: List<Shelve> = emptyList(),
)
