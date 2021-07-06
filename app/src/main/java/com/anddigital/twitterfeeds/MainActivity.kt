package com.anddigital.twitterfeeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.anddigital.twitterfeeds.data.utils.Resource
import com.anddigital.twitterfeeds.databinding.ActivityMainBinding
import com.anddigital.twitterfeeds.presentation.adapter.TweetsListAdapter
import com.anddigital.twitterfeeds.presentation.viewmodel.TweetViewModelFactory
import com.anddigital.twitterfeeds.presentation.viewmodel.TweetsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TweetViewModelFactory

    @Inject
    lateinit var tweetsAdapter: TweetsListAdapter
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: TweetsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, factory).get(TweetsViewModel::class.java)
        initRecyclerView()
        loadTweets()
    }

    private fun loadTweets() {
        viewModel.getTweets()
        viewModel.tweets.observe(this, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        Log.d("List in Activity  ", it.toString())
                        tweetsAdapter.differ.submitList(it)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { errorMessage ->
                        Toast.makeText(
                            this,
                            "An error occurred : $errorMessage",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun initRecyclerView() {
        binding.recyclerViewTweets.apply {
            adapter = tweetsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }
}