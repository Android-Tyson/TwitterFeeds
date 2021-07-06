package com.anddigital.twitterfeeds.data.repository.dataSourceImpl

import com.anddigital.twitterfeeds.data.api.TweetsAPIService
import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsRemoteDataSource
import com.anddigital.twitterfeeds.data.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TweetsRemoteDataSourceImplTest: BaseUnitTest(){
    lateinit var remoteDataSource: TweetsRemoteDataSource
    private val  apiService : TweetsAPIService = mock()
    private val exception = RuntimeException("Something went wrong")
    private val apiResponse = mock<ApiTweetResponse>()

    @Test
    fun getApiResponseFromRemoteDataSource() = runBlockingTest{
        remoteDataSource = mockSuccessfulCase()
        remoteDataSource.getTweets()

        verify(apiService, times(1)).getTweets()
    }

    @Test
    fun getApiResponseFromRemoteDataSource_expectedReceived() = runBlockingTest {
        remoteDataSource = mockSuccessfulCase()

        assertEquals(apiResponse, remoteDataSource.getTweets().body())
    }

    private suspend fun mockSuccessfulCase(): TweetsRemoteDataSource {
        whenever(apiService.getTweets()).thenReturn(
            Response.success(apiResponse)
        )
        return TweetsRemoteDataSourceImpl(apiService)
    }
}