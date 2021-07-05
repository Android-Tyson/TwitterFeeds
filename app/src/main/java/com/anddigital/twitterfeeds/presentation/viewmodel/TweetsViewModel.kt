package com.anddigital.twitterfeeds.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.utils.Resource
import com.anddigital.twitterfeeds.domain.repository.TweetsRepository
import com.anddigital.twitterfeeds.domain.usecase.GetTweetsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TweetsViewModel(
    private val appContext: Application,
    private val getTweetsUseCase: GetTweetsUseCase
) : AndroidViewModel(appContext) {

    val tweets: MutableLiveData<Resource<ApiTweetResponse>> = MutableLiveData()

    fun getTweets() = viewModelScope.launch(Dispatchers.IO) {
        tweets.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(appContext)) {
                val apiResult = getTweetsUseCase.execute()
                tweets.postValue(apiResult)
            } else {
                tweets.postValue(Resource.Error("No internet connection!!"))
            }
        } catch (e: Exception) {
            tweets.postValue(Resource.Error(e.message.toString()))
        }
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

}

