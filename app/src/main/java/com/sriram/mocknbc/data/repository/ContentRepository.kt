package com.sriram.mocknbc.data.repository

import android.content.Context
import com.sriram.mocknbc.data.model.Shelve

interface ContentRepository {
    suspend fun getScreenContent(pageName: String, context: Context): List<Shelve>?
}
