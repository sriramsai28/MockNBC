package com.sriram.mocknbc.di

import com.sriram.mocknbc.data.repository.ContentRepository
import com.sriram.mocknbc.domain.usecase.HomeScreenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(
        contentRepository: ContentRepository,
    ): HomeScreenUseCase {
        return HomeScreenUseCase(contentRepository)
    }
}
