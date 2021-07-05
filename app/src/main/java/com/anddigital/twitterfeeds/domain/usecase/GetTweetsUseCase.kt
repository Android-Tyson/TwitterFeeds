package com.anddigital.twitterfeeds.domain.usecase

import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.model.ApiTweetResponseItem
import com.anddigital.twitterfeeds.data.utils.Resource
import com.anddigital.twitterfeeds.domain.repository.TweetsRepository

class GetTweetsUseCase(private val repository: TweetsRepository) {
    suspend fun execute() : Resource<ApiTweetResponse>{
        return repository.getTweets()
    }
}