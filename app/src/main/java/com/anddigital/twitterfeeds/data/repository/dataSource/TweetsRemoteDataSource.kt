package com.anddigital.twitterfeeds.data.repository.dataSource

import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import retrofit2.Response

interface TweetsRemoteDataSource {
    suspend fun getTweets():Response<ApiTweetResponse>
}