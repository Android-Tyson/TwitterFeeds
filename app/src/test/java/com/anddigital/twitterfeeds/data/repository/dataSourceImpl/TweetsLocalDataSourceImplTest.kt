package com.anddigital.twitterfeeds.data.repository.dataSourceImpl

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.anddigital.twitterfeeds.data.db.TweetsDao
import com.anddigital.twitterfeeds.data.db.TwitterDatabase
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsLocalDataSource
import com.anddigital.twitterfeeds.data.utils.BaseUnitTest
import com.anddigital.twitterfeeds.domain.entity.Tweets
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test

class TweetsLocalDataSourceImplTest : BaseUnitTest(){
    lateinit var localDataSource: TweetsLocalDataSource
    private val tweetsDao : TweetsDao = mock()
    private val tweetsList = mock<List<Tweets>>()

    @Test
    fun getTweetsList_called_FromLocalDataSource() = runBlockingTest {
        localDataSource = mockSuccessfulCase()
        localDataSource.getTweetsFromDB()

        verify(tweetsDao, times(1)).getTweets()
    }

    @Test
    fun getTweetsList_FromLocalDataSource_expectedReceived() = runBlockingTest {
        localDataSource = mockSuccessfulCase()

        assertEquals(tweetsList, localDataSource.getTweetsFromDB())
    }

    private suspend fun mockSuccessfulCase(): TweetsLocalDataSource {
        whenever(tweetsDao.getTweets()).thenReturn(
            tweetsList
        )
        return TweetsLocalDataSourceImpl(tweetsDao)
    }

}