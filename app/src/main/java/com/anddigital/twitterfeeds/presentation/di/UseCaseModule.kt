package com.anddigital.twitterfeeds.presentation.di

import com.anddigital.twitterfeeds.domain.repository.TweetsRepository
import com.anddigital.twitterfeeds.domain.usecase.GetTweetsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetTweetsUseCase(repository: TweetsRepository): GetTweetsUseCase {
        return GetTweetsUseCase(repository)
    }
}