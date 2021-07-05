package com.anddigital.twitterfeeds.data.api

import com.anddigital.twitterfeeds.BuildConfig
import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TweetsAPIService {

    @Headers("Authorization: ${BuildConfig.AUTH_VALUE}")
    @GET("1.1/lists/statuses.json")
    suspend fun getTweets(
        @Query("list_id") listId: String = BuildConfig.LIST_ID,
        @Query("tweet_mode") tweetMode: String = "extended",
        @Query("include_entities") includeEntities: Int = 1,
        @Query("count") count: Int = 10
    ): Response<ApiTweetResponse>
}