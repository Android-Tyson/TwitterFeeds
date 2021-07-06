package com.anddigital.twitterfeeds.presentation.di

import com.anddigital.twitterfeeds.data.entity.EntityMapper
import com.anddigital.twitterfeeds.data.repository.TweetsRepositoryImpl
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsLocalDataSource
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsRemoteDataSource
import com.anddigital.twitterfeeds.domain.repository.TweetsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesTweetRepository(
        tweetsRemoteDataSource: TweetsRemoteDataSource,
        tweetsLocalDataSource: TweetsLocalDataSource,
    ): TweetsRepository {
        return TweetsRepositoryImpl(tweetsRemoteDataSource,tweetsLocalDataSource)
    }
}