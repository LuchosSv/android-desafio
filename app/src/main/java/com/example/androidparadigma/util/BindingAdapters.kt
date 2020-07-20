package com.example.androidparadigma.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
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

//binding adapter for change visibility
@BindingAdapter("app:progressBarVisibility")
fun changeVisibility(progressBar: ProgressBar, status: String?) {
    status?.let {
        when (it) {
            LOADING -> progressBar.visibility = View.VISIBLE
            SUCCESS -> progressBar.visibility = View.GONE
            ERROR -> progressBar.visibility = View.GONE
        }
    }
}

//binding adpter for show error message
@BindingAdapter("app:errorMessageVisibility", "app:errorMessageText")
fun showMessageException(textView: TextView, message: String?, errorMessage: String?) {
    message?.let {
        when (it) {
            ERROR -> {
                textView.visibility = View.VISIBLE
                textView.text = errorMessage
            }
            else -> {
                textView.visibility = View.GONE
            }
        }
    }
}

//binding adapter for show image when as error
@BindingAdapter("app:connectionError")
fun errorConnection(image: ImageView, message: String?) {
    message?.let {
        when (it) {
            ERROR -> {
                image.visibility = View.VISIBLE
            }
            else -> {
                image.visibility = View.GONE
            }
        }
    }
}