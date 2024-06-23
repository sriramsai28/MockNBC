package com.sriram.mocknbc.ui.delegate

import BaseAdapterDelegateTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.sriram.mocknbc.databinding.LiveItemBinding
import com.sriram.mocknbc.ui.model.ItemGroup
import com.sriram.mocknbc.ui.model.ItemGroupType
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode

@Config(sdk = [32])
@LooperMode(LooperMode.Mode.PAUSED)
@RunWith(AndroidJUnit4::class)
class LiveDelegateKtTest : BaseAdapterDelegateTest<ItemGroup, ItemGroup.LIVE, LiveItemBinding>() {

    @Test
    fun `BindData`() {
        val liveItem = ItemGroup.LIVE(
            image = "",
            labelBadge = "",
            subtitle = "test sub string",
            tagline = "test tagline",
            title = "test title",
            type = ItemGroupType.Live,
        )
        testBinding(liveItem) {
            assertThat(binding.title.text).isEqualTo(liveItem.title)
            assertThat(binding.subTitle.text).isEqualTo(liveItem.subtitle)
        }
    }

    override fun createDelegate(): AdapterDelegate<List<ItemGroup>> {
        return liveDelegate()
    }
}
