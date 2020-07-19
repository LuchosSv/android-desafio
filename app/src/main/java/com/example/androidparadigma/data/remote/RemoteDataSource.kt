package com.example.androidparadigma.data.remote

import com.example.androidparadigma.util.RetrofitFactory

class RemoteDataSource (){

    val request = RetrofitFactory.RetrofitService()

    suspend fun getPostListRemote() = request.getPosts()

    suspend fun getPostByIdRemote(id: Int) = request.getPostsById(id)

    suspend fun getComments() = request.getComments()

}

