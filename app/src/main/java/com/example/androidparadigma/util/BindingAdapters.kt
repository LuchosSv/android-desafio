package com.example.androidparadigma.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidparadigma.adapter.PostsAdapter
import com.example.androidparadigma.model.PostsResponse

@BindingAdapter("app:sendPostList")
fun postsWithRecyclerView(recyclerView: RecyclerView, postsList: List<PostsResponse>?) {
    postsList?.let {
        (recyclerView.adapter as PostsAdapter).submitList(postsList)
    }
}