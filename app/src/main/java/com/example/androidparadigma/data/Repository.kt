package com.example.androidparadigma.data

import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonEntity
import com.example.androidparadigma.data.remote.PostsEntity
import com.example.androidparadigma.data.remote.RemoteDataSource
import com.example.androidparadigma.model.CommentsResponse
import com.example.androidparadigma.model.PostsResponse

class Repository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    //REMOTE

    //get list of posts
    suspend fun getPostListRemote(): List<PostsResponse> {
        return remoteDataSource.getPostListRemote()
    }

    //get posts by id
    suspend fun getPostsByIdRemote(id: Int): PostsResponse{
        return remoteDataSource.getPostByIdRemote(id)
    }

    //get list of comments
    suspend fun getComments(): List<CommentsResponse>{
        return remoteDataSource.getComments()
    }

    //LOCAL

    //get object person
    fun getPersonLocalRepository() = localDataSource.getPersonLocal()

    //insert object person
    suspend fun insertLocalRepositoryPerson(personEntity: PersonEntity) {
        localDataSource.insertLocalPerson(personEntity)
    }

    //save posts in favorite, local
    suspend fun insertPostsLocal(postsEntity: PostsEntity){
        localDataSource.insertPostsLocal(postsEntity)
    }

    //get list of posts to database
    fun getListPostLocal() = localDataSource.getListPostsLocal()

    //delete object posts from list to database
    suspend fun deletePostsLocal(postsEntity: PostsEntity){
        localDataSource.deletePostsLocal(postsEntity)
    }

    fun getCountPersonLocal() = localDataSource.getCountPersonLocal()

}