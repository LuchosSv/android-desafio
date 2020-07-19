package com.example.androidparadigma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidparadigma.databinding.CommentsListAdapterBinding
import com.example.androidparadigma.model.CommentsResponse

class CommentsAdapter() : ListAdapter<CommentsResponse, CommentsAdapter.CommentsViewHolder>(DiffCallBack) {

    class CommentsViewHolder(private val binding: CommentsListAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun boom(commentsResponse: CommentsResponse) {
            binding.commentName.text = commentsResponse.name
            binding.commentBody.text = commentsResponse.body
            binding.commentEmail.text = commentsResponse.email
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<CommentsResponse>() {
        override fun areItemsTheSame(
            oldItem: CommentsResponse,
            newItem: CommentsResponse
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: CommentsResponse,
            newItem: CommentsResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        return CommentsViewHolder(
            CommentsListAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val item = getItem(position)
        holder.boom(item)
    }

}