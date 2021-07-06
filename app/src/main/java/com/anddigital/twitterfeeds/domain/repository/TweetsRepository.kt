package com.anddigital.twitterfeeds.domain.repository

import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.utils.Resource
import com.anddigital.twitterfeeds.domain.entity.Tweets

interface TweetsRepository {
//    suspend fun getTweets(): Resource<ApiTweetResponse>
    suspend fun getTweets(): Resource<List<Tweets>>

}