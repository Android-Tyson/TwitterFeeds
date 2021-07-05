package com.anddigital.twitterfeeds.presentation.di.core

import com.anddigital.twitterfeeds.BuildConfig
import com.anddigital.twitterfeeds.data.api.TweetsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideTweetsApiService(retrofit: Retrofit): TweetsAPIService = retrofit.create(TweetsAPIService::class.java)
}