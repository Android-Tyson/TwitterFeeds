package com.anddigital.twitterfeeds.data.repository.dataSourceImpl

import com.anddigital.twitterfeeds.data.api.TweetsAPIService
import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsRemoteDataSource
import retrofit2.Response

class TweetsRemoteDataSourceImpl(
    private val tweetsAPIService: TweetsAPIService
) : TweetsRemoteDataSource {
    override suspend fun getTweets(): Response<ApiTweetResponse> {
        return tweetsAPIService.getTweets()
    }
}