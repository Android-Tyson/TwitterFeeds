package com.anddigital.twitterfeeds.presentation.di.core

import com.anddigital.twitterfeeds.data.db.TweetsDao
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsLocalDataSource
import com.anddigital.twitterfeeds.data.repository.dataSourceImpl.TweetsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(tweetsDao: TweetsDao): TweetsLocalDataSource {
        return TweetsLocalDataSourceImpl(tweetsDao)
    }
}
