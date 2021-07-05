package com.anddigital.twitterfeeds.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anddigital.twitterfeeds.domain.usecase.GetTweetsUseCase

class TweetViewModelFactory(
    private val appContext : Application,
    private val getTweetsUseCase: GetTweetsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TweetsViewModel(appContext,getTweetsUseCase) as T
    }
}