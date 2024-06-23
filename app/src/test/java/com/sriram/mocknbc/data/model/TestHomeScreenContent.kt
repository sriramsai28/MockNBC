package com.sriram.mocknbc.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TestHomeScreenContent {

    @Test
    fun `test HomeScreenContent constructor with empty data`() {
        HomeScreenContent("").run {
            assertThat(page).isEmpty()
            assertThat(shelves).isEmpty()
        }
    }

    @Test
    fun `test HomeScreenContent constructor with data`() {
        val shelveList = listOf(
            Shelve(
                title = "Continue Watching",
                type = "shelve",
                items = listOf(
                    Item(
                        image = "https://img.nbc.com/sites/nbcunbc/files/images/2021/2/04/NBC-News_2048_1152.jpg",
                        type = "live",
                        subtitle = "Live News Streaming",
                        title = "Hallie Jackson NOW",
                        labelBadge = "",
                        tagline = "",
                    ),
                ),
            ),
        )
        HomeScreenContent("Homepage", shelveList).run {
            assertThat(page).isEqualTo("Homepage")
            assertThat(shelves).hasSize(1)
        }
    }
}
