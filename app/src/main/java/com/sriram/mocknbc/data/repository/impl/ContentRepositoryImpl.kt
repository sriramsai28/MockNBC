package com.sriram.mocknbc.data.repository.impl

import android.content.Context
import com.sriram.mocknbc.data.dataSource.RemoteDataSource
import com.sriram.mocknbc.data.model.Shelve
import com.sriram.mocknbc.data.repository.ContentRepository
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : ContentRepository {
    override suspend fun getScreenContent(pageName: String, context: Context): List<Shelve>? {
        return remoteDataSource.getPageContentFromAPI(pageName = pageName, context = context)
    }
}
