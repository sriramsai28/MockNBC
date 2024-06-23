package com.sriram.mocknbc.data.dataSource

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import createContext
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode

@Config(sdk = [32])
@LooperMode(LooperMode.Mode.PAUSED)
@RunWith(AndroidJUnit4::class)
class RemoteDataSourceTest {
    private lateinit var dataSource: RemoteDataSource

    @Before
    fun setup() {
        dataSource = RemoteDataSourceTestImpl()
    }

    @Test
    fun `test RemoteDataSource`() {
        runBlocking {
            val response = dataSource.getPageContentFromAPI("HOMEPAGE", createContext())
            assertThat(response).isNotEmpty()
            assertThat(response?.size).isEqualTo(3)
        }
    }

    @Test
    fun `test RemoteDataSource different Page name`() {
        runBlocking {
            val response = dataSource.getPageContentFromAPI("Details", createContext())
            assertThat(response).isEmpty()
            assertThat(response?.size).isEqualTo(0)
        }
    }
}
