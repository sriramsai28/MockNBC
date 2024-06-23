package com.sriram.mocknbc.ui.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.sriram.mocknbc.ui.delegate.episodeDelegate
import com.sriram.mocknbc.ui.delegate.liveDelegate
import com.sriram.mocknbc.ui.delegate.showDelegate
import com.sriram.mocknbc.ui.model.ItemGroup

fun createCarouselAdapter() = ListDelegationAdapter<List<ItemGroup>>(
    liveDelegate(),
    showDelegate(),
    episodeDelegate(),
)