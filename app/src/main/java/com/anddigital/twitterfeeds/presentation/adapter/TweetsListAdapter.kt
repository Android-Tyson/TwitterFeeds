package com.anddigital.twitterfeeds.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.anddigital.twitterfeeds.data.model.ApiTweetResponse
import com.anddigital.twitterfeeds.data.model.ApiTweetResponseItem
import com.anddigital.twitterfeeds.databinding.TweetsListItemBinding

class TweetsListAdapter : RecyclerView.Adapter<TweetsListAdapter.TweetViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<ApiTweetResponseItem>() {
        override fun areItemsTheSame(
            oldItem: ApiTweetResponseItem,
            newItem: ApiTweetResponseItem
        ): Boolean {
            return oldItem.fullText == newItem.fullText
        }

        override fun areContentsTheSame(
            oldItem: ApiTweetResponseItem,
            newItem: ApiTweetResponseItem
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

        fun bind(responseItem: ApiTweetResponseItem) {
            binding.textViewDateTime.text = responseItem.createdAt
            binding.textViewTweets.text = responseItem.fullText
        }
    }
}
