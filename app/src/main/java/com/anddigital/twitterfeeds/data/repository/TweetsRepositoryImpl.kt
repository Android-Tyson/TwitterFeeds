package com.anddigital.twitterfeeds.data.repository

import android.util.Log
import com.anddigital.twitterfeeds.data.entity.EntityMapper
import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.model.ApiTweetResponseItem
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsLocalDataSource
import com.anddigital.twitterfeeds.data.repository.dataSource.TweetsRemoteDataSource
import com.anddigital.twitterfeeds.data.utils.Resource
import com.anddigital.twitterfeeds.domain.entity.Tweets
import com.anddigital.twitterfeeds.domain.repository.TweetsRepository
import retrofit2.Response

class TweetsRepositoryImpl(
    private val tweetsRemoteDataSource: TweetsRemoteDataSource,
    private val tweetsLocalDataSource: TweetsLocalDataSource
) : TweetsRepository {
    override suspend fun getTweets(): Resource<List<Tweets>> {
        return getTweetsFromLocalDB()
    }

    private suspend fun getTweetsFromAPI(): Resource<List<ApiTweetResponseItem>> {
        lateinit var tweetsList: List<ApiTweetResponseItem>
        try {
            val response: Response<ApiTweetResponse> = tweetsRemoteDataSource.getTweets()
            val body: ApiTweetResponse? = response.body()
            if (body != null) {
                tweetsList = body.toList()
            }
        } catch (e: Exception) {
            Log.i("TweetsRepositoryImpl", e.message.toString())
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(tweetsList)
    }

    private suspend fun getTweetsFromLocalDB(): Resource<List<Tweets>> {
        var tweetsList: ArrayList<Tweets> = ArrayList()
        lateinit var apiTweetsList: List<ApiTweetResponseItem>
        try {
            tweetsList.addAll(tweetsLocalDataSource.getTweetsFromDB())
        } catch (e: Exception) {
            Log.i("TweetsRepositoryImpl", e.message.toString())
            return Resource.Error(e.message.toString())
        }
        if (tweetsList.isNotEmpty()) {
            return Resource.Success(tweetsList)
        } else {
            apiTweetsList = getTweetsFromAPI().data!!
            for (item in apiTweetsList) {
                tweetsList.add(EntityMapper().mapLeftToRight(item))
                tweetsLocalDataSource.saveTweetsToDB(tweetsList)
            }
        }
        return Resource.Success(tweetsList)
    }
//    override suspend fun getTweets(): Resource<ApiTweetResponse> {
//        return responseToResource(tweetsRemoteDataSource.getTweets())
//    }
//
//    private fun responseToResource(response: Response<ApiTweetResponse>): Resource<ApiTweetResponse> {
//        if (response.isSuccessful) {
//            response.body()?.let { result ->
//                return Resource.Success(result)
//            }
//        }
//        return Resource.Error(response.message())
//    }

}