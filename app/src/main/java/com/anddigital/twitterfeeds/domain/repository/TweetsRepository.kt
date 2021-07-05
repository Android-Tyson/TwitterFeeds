package com.anddigital.twitterfeeds.domain.repository

import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.utils.Resource

interface TweetsRepository {
    suspend fun getTweets(): Resource<ApiTweetResponse>
}