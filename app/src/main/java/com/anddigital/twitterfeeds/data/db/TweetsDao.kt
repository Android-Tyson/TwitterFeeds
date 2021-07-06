package com.anddigital.twitterfeeds.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anddigital.twitterfeeds.domain.entity.Tweets

@Dao
interface TweetsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTweets(tweets: List<Tweets>)

    @Query("DELETE FROM tweets")
    suspend fun deleteAllTweets()

    @Query("SELECT * FROM tweets")
    suspend fun getTweets() : List<Tweets>
}