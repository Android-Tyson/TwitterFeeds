package com.anddigital.twitterfeeds.data.repository.dataSourceImpl

import com.anddigital.twitterfeeds.data.db.TweetsDao
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsLocalDataSource
import com.anddigital.twitterfeeds.domain.entity.Tweets
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TweetsLocalDataSourceImpl(
    private val tweetsDao: TweetsDao
) : TweetsLocalDataSource {
    override suspend fun getTweetsFromDB(): List<Tweets> {
        return tweetsDao.getTweets()
    }

    override suspend fun saveTweetsToDB(tweets: List<Tweets>) {
        CoroutineScope(Dispatchers.IO).launch {
            tweetsDao.saveTweets(tweets)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tweetsDao.deleteAllTweets()
        }
    }
}