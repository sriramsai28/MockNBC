package com.sriram.mocknbc.di

import com.sriram.mocknbc.domain.usecase.HomeScreenUseCase
import com.sriram.mocknbc.domain.viewmodel.HomeScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {
    @Provides
    fun provideHomeViewModel(useCase: HomeScreenUseCase): HomeScreenViewModel =
        HomeScreenViewModel(useCase)
}
