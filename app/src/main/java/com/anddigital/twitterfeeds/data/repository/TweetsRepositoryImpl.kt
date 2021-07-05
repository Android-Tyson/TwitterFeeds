package com.anddigital.twitterfeeds.data.repository

import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsRemoteDataSource
import com.anddigital.twitterfeeds.data.utils.Resource
import com.anddigital.twitterfeeds.domain.repository.TweetsRepository
import retrofit2.Response

class TweetsRepositoryImpl(
    private val tweetsRemoteDataSource: TweetsRemoteDataSource
) : TweetsRepository {
    override suspend fun getTweets(): Resource<ApiTweetResponse> {
        return responseToResource(tweetsRemoteDataSource.getTweets())
    }

    private fun responseToResource(response: Response<ApiTweetResponse>): Resource<ApiTweetResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}