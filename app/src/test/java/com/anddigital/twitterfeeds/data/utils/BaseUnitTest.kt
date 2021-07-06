package com.anddigital.twitterfeeds.data.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule

open class BaseUnitTest {

    @get : Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @get : Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
}