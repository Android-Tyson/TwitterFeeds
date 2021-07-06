package com.anddigital.twitterfeeds.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.model.ApiTweetResponseItem
import com.anddigital.twitterfeeds.databinding.TweetsListItemBinding
import com.anddigital.twitterfeeds.domain.entity.Tweets

class TweetsListAdapter : RecyclerView.Adapter<TweetsListAdapter.TweetViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Tweets>() {
        override fun areItemsTheSame(
            oldItem: Tweets,
            newItem: Tweets
        ): Boolean {
            return oldItem.tweet == newItem.tweet
        }

        override fun areContentsTheSame(
            oldItem: Tweets,
            newItem: Tweets
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val binding =
            TweetsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TweetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val tweets = differ.currentList[position]
        holder.bind(tweets)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class TweetViewHolder(private val binding: TweetsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tweets: Tweets) {
            binding.textViewDateTime.text = tweets.createdAt
            binding.textViewTweets.text = tweets.tweet
        }
    }
}
