package com.example.androidparadigma.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidparadigma.adapter.CommentsAdapter
import com.example.androidparadigma.adapter.PostsAdapter
import com.example.androidparadigma.adapter.ProfileAdapter
import com.example.androidparadigma.data.remote.PostsEntity
import com.example.androidparadigma.model.CommentsResponse
import com.example.androidparadigma.model.PostsResponse

//binding adapter for send posts list to recycleView
@BindingAdapter("app:sendPostList")
fun postsWithRecyclerView(recyclerView: RecyclerView, postsList: List<PostsResponse>?) {
    postsList?.let {
        (recyclerView.adapter as PostsAdapter).submitList(postsList)
    }
}

//binding adapter for send comment list to recycleView
@BindingAdapter("app:sendCommentsList")
fun commentssWithRecyclerView(recyclerView: RecyclerView, postsList: List<CommentsResponse>?) {
    postsList?.let {
        (recyclerView.adapter as CommentsAdapter).submitList(postsList)
    }
}

//binding adapter for send post list to recycleView, get data from database
@BindingAdapter("app:sendPostsListLocal")
fun PostsLocalWithRecyclerView(recyclerView: RecyclerView, postsList: List<PostsEntity>?) {
    postsList?.let {
        (recyclerView.adapter as ProfileAdapter).submitList(postsList)
    }
}