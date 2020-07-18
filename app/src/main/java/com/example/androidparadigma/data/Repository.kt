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
    
    suspend fun getUserByRepository(): List<PostsResponse> {
        return remoteDataSource.getPostListRemote()
    }

    //LOCAL

    fun getPersonLocalRepository() = localDataSource.getPersonLocal()

    suspend fun insertLocalRepositoryPerson(personEntity: PersonEntity) {
        localDataSource.insertLocalPerson(personEntity)
    }

    fun getCountPersonLocal() = localDataSource.getCountPersonLocal()

}