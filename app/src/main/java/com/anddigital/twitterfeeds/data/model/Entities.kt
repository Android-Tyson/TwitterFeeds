package com.anddigital.twitterfeeds.data.model


import com.google.gson.annotations.SerializedName

data class Entities(
    val hashtags: List<Hashtag>,
    val symbols: List<Any>,
    val urls: List<Url>,
    @SerializedName("user_mentions")
    val userMentions: List<UserMention>
)