package com.example.androidparadigma.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidparadigma.databinding.PostsListAdapterBinding
import com.example.androidparadigma.model.PostsResponse

class PostsAdapter(): ListAdapter<PostsResponse, PostsAdapter.PostsViewHolder>(DiffCallBack){

    class PostsViewHolder(private val binding: PostsListAdapterBinding): RecyclerView.ViewHolder(binding.root){
        fun boom(postsResponse: PostsResponse){
            Log.i("adapter","msg")
            binding.textView.text = postsResponse.title
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<PostsResponse>(){
        override fun areItemsTheSame(oldItem: PostsResponse, newItem: PostsResponse): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PostsResponse, newItem: PostsResponse): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            PostsListAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val item = getItem(position)
        holder.boom(item)
    }

}