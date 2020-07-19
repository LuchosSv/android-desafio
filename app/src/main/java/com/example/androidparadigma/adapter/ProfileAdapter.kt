package com.example.androidparadigma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidparadigma.data.remote.PostsEntity
import com.example.androidparadigma.databinding.PostsListAdapterBinding
import com.example.androidparadigma.databinding.ProfileListAdapterBinding
import kotlinx.android.synthetic.main.posts_list_adapter.view.*

class ProfileAdapter() : ListAdapter<PostsEntity, ProfileAdapter.ProfileViewHolder>(DiffCallBack) {

    class ProfileViewHolder(private val binding: ProfileListAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun boom(postsEntity: PostsEntity) {
            binding.textView.text = postsEntity.title
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<PostsEntity>() {
        override fun areItemsTheSame(oldItem: PostsEntity, newItem: PostsEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PostsEntity, newItem: PostsEntity): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileAdapter.ProfileViewHolder(
            ProfileListAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val item = getItem(position)
        holder.boom(item)
    }

}