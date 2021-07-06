package com.anddigital.twitterfeeds.domain.usecase

import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.model.ApiTweetResponseItem
import com.anddigital.twitterfeeds.data.utils.Resource
import com.anddigital.twitterfeeds.domain.entity.Tweets
import com.anddigital.twitterfeeds.domain.repository.TweetsRepository

class GetTweetsUseCase(private val repository: TweetsRepository) {
    suspend fun execute() : Resource<List<Tweets>>{
        return repository.getTweets()
    }
}