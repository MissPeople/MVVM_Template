package com.wzp.mvvm_template.data.di

import com.wzp.mvvm_template.data.remote.dataSource.ApiServiceDataSource
import com.wzp.mvvm_template.data.remote.dataSource.ApiServiceDataSourceImpl
import com.wzp.mvvm_template.data.repository.login.LoginRepository
import com.wzp.mvvm_template.data.repository.login.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * The main module should include this DI module.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideApiServiceDataSource(dataSourceImpl: ApiServiceDataSourceImpl): ApiServiceDataSource

    @Binds
    abstract fun provideLoginRepository(repo: LoginRepositoryImpl): LoginRepository

}