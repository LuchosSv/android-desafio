package com.example.androidparadigma.interfaces

import com.example.androidparadigma.model.PostsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostsResponse>



}