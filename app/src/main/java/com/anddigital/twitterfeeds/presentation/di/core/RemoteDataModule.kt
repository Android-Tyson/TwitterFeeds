package com.anddigital.twitterfeeds.presentation.di.core

import com.anddigital.twitterfeeds.data.api.TweetsAPIService
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsRemoteDataSource
import com.anddigital.twitterfeeds.data.repository.dataSourceImpl.TweetsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideTweetsRemoteDataSource(tweetsAPIService: TweetsAPIService): TweetsRemoteDataSource {
        return TweetsRemoteDataSourceImpl(tweetsAPIService)
    }
}