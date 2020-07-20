package com.example.androidparadigma.interfaces

import com.example.androidparadigma.model.CommentsResponse
import com.example.androidparadigma.model.PostsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostsResponse>

    @GET("posts/{id}")
    suspend fun getPostsById(@Path("id") id: Int): PostsResponse

    @GET("comments")
    suspend fun getComments(): List<CommentsResponse>

}