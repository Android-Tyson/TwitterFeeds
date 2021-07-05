package com.anddigital.twitterfeeds.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TweetsAPIServiceTest {
    private lateinit var service: TweetsAPIService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TweetsAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName: String
    ) {
        val inputStream = javaClass.classLoader.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        mockWebServer.enqueue(mockResponse)
    }

    @Test
    fun getTweets_sentRequests_receivedExpected() {
        runBlocking {
            enqueueMockResponse("tweetsresponse.json")
            val responseBody = service.getTweets().body()
            val request = mockWebServer.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/1.1/lists/statuses.json?list_id=871746761387323394&tweet_mode=extended&include_entities=1&count=10")

        }
    }

    @Test
    fun getTweets_receivedResponse_correctPageCountSize() {
        runBlocking {
            enqueueMockResponse("tweetsresponse.json")
            val responseBody = service.getTweets().body()
            val tweetsListSize = responseBody!!.size
            assertThat(tweetsListSize).isEqualTo(10)
        }
    }

    @Test
    fun getTweets_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("tweetsresponse.json")
            val responseBody = service.getTweets().body()
            val tweets = responseBody!![0]
            assertThat(tweets.fullText).isEqualTo("AND has reached 100 #AWS certifications, recognising our expertise in delivering #Cloud solutions. If you're embarking on your own #cloudtransformation, make sure you know what you're up against. Download our #cloudhandbook for the full run-down &gt;&gt; https://t.co/oWht7uhCfV https://t.co/YENvg16QMw")
            assertThat(tweets.user.name).isEqualTo("AND Digital")
        }
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}