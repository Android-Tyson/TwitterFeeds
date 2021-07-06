package com.anddigital.twitterfeeds.domain.base

interface Mapper<in LeftObject, out RightObject> {
    fun mapLeftToRight(obj : LeftObject) : RightObject
}