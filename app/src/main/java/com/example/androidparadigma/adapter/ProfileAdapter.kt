package com.example.androidparadigma.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidparadigma.data.remote.PostsEntity
import com.example.androidparadigma.databinding.PostsListAdapterBinding
import com.example.androidparadigma.databinding.ProfileListAdapterBinding
import kotlinx.android.synthetic.main.profile_list_adapter.view.*

class ProfileAdapter(
    private val onClickListener: ProfileAdapter.OnClickListener,
    private val onClickListener2: ProfileAdapter.OnClickListener2
) :
    ListAdapter<PostsEntity, ProfileAdapter.ProfileViewHolder>(DiffCallBack) {

    class ProfileViewHolder(private val binding: ProfileListAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun boom(postsEntity: PostsEntity) {

            if (postsEntity.id % 2 == 0) {
                binding.imageColor.setBackgroundColor(Color.parseColor("#CCE2A3"))
            } else {
                binding.imageColor.setBackgroundColor(Color.parseColor("#DACC3E"))
            }
            binding.numberIdPostProfile.text = postsEntity.id.toString()
            binding.postsProfile.text = postsEntity.title
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
        return ProfileViewHolder(
            ProfileListAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.posts_profile.setOnClickListener {
            onClickListener.onClick(item)
        }
        holder.itemView.posts_delete.setOnClickListener {
            onClickListener2.onClick2(item)
        }
        holder.boom(item)
    }

    class OnClickListener(val clickListener: (postsEntity: PostsEntity) -> Unit) {
        fun onClick(postsEntity: PostsEntity) = clickListener(postsEntity)
    }

    class OnClickListener2(val clickListener: (postsEntity: PostsEntity) -> Unit) {
        fun onClick2(postsEntity: PostsEntity) = clickListener(postsEntity)
    }

}