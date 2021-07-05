package com.anddigital.twitterfeeds.data.model


import com.google.gson.annotations.SerializedName

data class QuotedStatus(
    val contributors: Any,
    val coordinates: Any,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("display_text_range")
    val displayTextRange: List<Int>,
    val entities: EntitiesX,
    @SerializedName("extended_entities")
    val extendedEntities: ExtendedEntitiesX,
    @SerializedName("favorite_count")
    val favoriteCount: Int,
    val favorited: Boolean,
    @SerializedName("full_text")
    val fullText: String,
    val geo: Any,
    val id: Long,
    @SerializedName("id_str")
    val idStr: String,
    @SerializedName("in_reply_to_screen_name")
    val inReplyToScreenName: Any,
    @SerializedName("in_reply_to_status_id")
    val inReplyToStatusId: Any,
    @SerializedName("in_reply_to_status_id_str")
    val inReplyToStatusIdStr: Any,
    @SerializedName("in_reply_to_user_id")
    val inReplyToUserId: Any,
    @SerializedName("in_reply_to_user_id_str")
    val inReplyToUserIdStr: Any,
    @SerializedName("is_quote_status")
    val isQuoteStatus: Boolean,
    val lang: String,
    val place: Any,
    @SerializedName("possibly_sensitive")
    val possiblySensitive: Boolean,
    @SerializedName("retweet_count")
    val retweetCount: Int,
    val retweeted: Boolean,
    val source: String,
    val truncated: Boolean,
    val user: User
)