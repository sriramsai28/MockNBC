package com.sriram.mocknbc.data.dataSource

import android.content.Context
import com.sriram.mocknbc.data.model.Shelve

interface RemoteDataSource {
    suspend fun getPageContentFromAPI(pageName: String, context: Context?): List<Shelve>?
}
