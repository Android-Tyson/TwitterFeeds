package com.anddigital.twitterfeeds.data.model


import com.google.gson.annotations.SerializedName

data class MediaXX(
    @SerializedName("display_url")
    val displayUrl: String,
    @SerializedName("expanded_url")
    val expandedUrl: String,
    val id: Long,
    @SerializedName("id_str")
    val idStr: String,
    val indices: List<Int>,
    @SerializedName("media_url")
    val mediaUrl: String,
    @SerializedName("media_url_https")
    val mediaUrlHttps: String,
    val sizes: SizesXX,
    val type: String,
    val url: String
)