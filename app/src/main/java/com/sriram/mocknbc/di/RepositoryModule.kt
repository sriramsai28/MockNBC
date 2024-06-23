package com.sriram.mocknbc.di

import com.sriram.mocknbc.data.repository.ContentRepository
import com.sriram.mocknbc.data.repository.impl.ContentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(
        repositoryImpl: ContentRepositoryImpl,
    ): ContentRepository
}
