package com.anddigital.twitterfeeds.presentation.di

import android.app.Application
import com.anddigital.twitterfeeds.domain.usecase.GetTweetsUseCase
import com.anddigital.twitterfeeds.presentation.viewmodel.TweetViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideTweetsViewModelFactory(
        application: Application,
        getTweetsUseCase: GetTweetsUseCase
    ): TweetViewModelFactory {
        return TweetViewModelFactory(application, getTweetsUseCase)
    }
}