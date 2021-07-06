package com.anddigital.twitterfeeds.data.repository.dataSource

import com.anddigital.twitterfeeds.domain.entity.Tweets

interface TweetsLocalDataSource {
    suspend fun getTweetsFromDB() : List<Tweets>
    suspend fun saveTweetsToDB(tweets: List<Tweets>)
    suspend fun clearAll()
}