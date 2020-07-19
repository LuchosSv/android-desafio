package com.example.androidparadigma.data

import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonEntity
import com.example.androidparadigma.data.remote.RemoteDataSource
import com.example.androidparadigma.model.PostsResponse

class Repository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    //REMOTE

    //get list if posts
    suspend fun getPostListRemote(): List<PostsResponse> {
        return remoteDataSource.getPostListRemote()
    }

    //LOCAL

    //get object person
    fun getPersonLocalRepository() = localDataSource.getPersonLocal()

    //insert object person
    suspend fun insertLocalRepositoryPerson(personEntity: PersonEntity) {
        localDataSource.insertLocalPerson(personEntity)
    }

    //get tables created
    fun getCountPersonLocal() = localDataSource.getCountPersonLocal()
    //get list of posts local //fail
    fun getListPostsLocal() = localDataSource.getListPostsLocal()

}