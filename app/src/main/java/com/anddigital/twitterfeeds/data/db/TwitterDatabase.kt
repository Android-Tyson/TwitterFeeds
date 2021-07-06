package com.anddigital.twitterfeeds.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anddigital.twitterfeeds.domain.entity.Tweets


@Database(
    entities = [Tweets::class],
    version = 1,
    exportSchema = false
)
abstract class TwitterDatabase : RoomDatabase() {
    abstract fun tweetsDao(): TweetsDao
}