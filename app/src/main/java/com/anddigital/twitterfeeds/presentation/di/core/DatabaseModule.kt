package com.anddigital.twitterfeeds.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.anddigital.twitterfeeds.data.db.TweetsDao
import com.anddigital.twitterfeeds.data.db.TwitterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideTwitterDatabase(@ApplicationContext context: Context): TwitterDatabase {
        return Room.databaseBuilder(context, TwitterDatabase::class.java, "twitterclient").build()
    }

    @Singleton
    @Provides
    fun provideTweetsDao(twitterDatabase: TwitterDatabase) : TweetsDao{
        return twitterDatabase.tweetsDao()
    }
}