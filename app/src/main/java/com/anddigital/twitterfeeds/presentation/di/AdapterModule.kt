package com.anddigital.twitterfeeds.presentation.di

import com.anddigital.twitterfeeds.presentation.adapter.TweetsListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideTweetsAdapter(): TweetsListAdapter {
        return TweetsListAdapter()
    }
}