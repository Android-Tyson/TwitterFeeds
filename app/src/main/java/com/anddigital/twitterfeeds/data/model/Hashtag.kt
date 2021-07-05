package com.anddigital.twitterfeeds.data.model


import com.google.gson.annotations.SerializedName

data class Hashtag(
    val indices: List<Int>,
    val text: String
)