package com.anddigital.twitterfeeds.data.factory

import java.util.*
import kotlin.random.Random

object DataFactory {
    fun generateRandomString() : String{
        return UUID.randomUUID().toString().substring(0,15)
    }
    fun getRandomInt(): Int {
        return Random.nextInt()
    }

    fun getRandomLong(): Long {
        return Random.nextLong()
    }

    fun getRandomDouble(): Double {
        return Random.nextDouble()
    }

    fun getRandomBoolean(): Boolean {
        return Random.nextBoolean()
    }
}