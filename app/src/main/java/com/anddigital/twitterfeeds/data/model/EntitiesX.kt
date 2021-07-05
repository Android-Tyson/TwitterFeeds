package com.anddigital.twitterfeeds.data.model


import com.google.gson.annotations.SerializedName

data class EntitiesX(
    val hashtags: List<Any>,
    val media: List<MediaX>,
    val symbols: List<Any>,
    val urls: List<UrlX>,
    @SerializedName("user_mentions")
    val userMentions: List<UserMentionX>
)