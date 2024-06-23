package com.sriram.mocknbc.domain.usecase

import android.content.Context
import com.sriram.mocknbc.data.model.Shelve
import com.sriram.mocknbc.data.repository.ContentRepository
import javax.inject.Inject

const val HOME_SCREEN = "HOMEPAGE"

class HomeScreenUseCase @Inject constructor(
    private val repository: ContentRepository,
) {
    suspend fun getHomeScreenContent(context: Context): List<Shelve>? =
        repository.getScreenContent(pageName = HOME_SCREEN, context = context)
}
