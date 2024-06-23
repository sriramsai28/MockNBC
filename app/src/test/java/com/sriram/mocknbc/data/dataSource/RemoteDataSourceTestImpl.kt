package com.sriram.mocknbc.data.dataSource

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sriram.mocknbc.data.model.HomeScreenContent
import com.sriram.mocknbc.data.model.Shelve

class RemoteDataSourceTestImpl : RemoteDataSource {
    override suspend fun getPageContentFromAPI(pageName: String, context: Context?): List<Shelve>? {
        val response: HomeScreenContent = Gson().fromJson(
            getData(context = context),
            object : TypeToken<HomeScreenContent>() {}.type,
        )
        return if (response.page == pageName) {
            response.shelves
        } else {
            emptyList()
        }
    }

    private fun getData(context: Context?): String {
        return context?.assets?.open("HomeScreenResponse.json")?.bufferedReader()
            .use { it?.readText().toString() }
    }
}
