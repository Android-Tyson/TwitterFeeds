package com.anddigital.twitterfeeds.data.model


import com.google.gson.annotations.SerializedName

data class QuotedStatusPermalink(
    val display: String,
    val expanded: String,
    val url: String
)