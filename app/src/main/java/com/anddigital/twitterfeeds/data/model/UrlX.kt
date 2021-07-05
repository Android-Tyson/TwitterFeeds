package com.anddigital.twitterfeeds.data.model


import com.google.gson.annotations.SerializedName

data class UrlX(
    @SerializedName("display_url")
    val displayUrl: String,
    @SerializedName("expanded_url")
    val expandedUrl: String,
    val indices: List<Int>,
    val url: String
)