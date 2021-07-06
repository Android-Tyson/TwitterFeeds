package com.anddigital.twitterfeeds.data.entity

import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.model.ApiTweetResponseItem
import com.anddigital.twitterfeeds.domain.base.Mapper
import com.anddigital.twitterfeeds.domain.entity.Tweets

class EntityMapper : Mapper<ApiTweetResponseItem, Tweets> {
        override fun mapLeftToRight(obj: ApiTweetResponseItem): Tweets = with(obj){
        Tweets(
            id = id,
            name = user.name,
            tweet = fullText,
            createdAt = createdAt
        )
    }
}