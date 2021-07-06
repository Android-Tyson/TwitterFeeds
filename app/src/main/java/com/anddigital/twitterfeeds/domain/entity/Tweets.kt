package com.anddigital.twitterfeeds.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tweets")
data class Tweets(
    @PrimaryKey
    val id : Long,
    val name : String,
    val tweet : String,
    val createdAt : String
)