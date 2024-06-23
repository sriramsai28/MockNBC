package com.sriram.mocknbc.di

import com.sriram.mocknbc.data.dataSource.RemoteDataSource
import com.sriram.mocknbc.data.dataSource.impl.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl,
    ): RemoteDataSource
}
