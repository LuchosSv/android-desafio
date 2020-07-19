package com.example.androidparadigma.data.local

import com.example.androidparadigma.data.remote.PostsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource (private val personDao: PersonDao){

    fun getPersonLocal() = personDao.getPersonLocal()

    suspend fun insertLocalPerson(userEntity: PersonEntity) = withContext(Dispatchers.IO) {
        personDao.insertLocalPerson(userEntity)
    }

    suspend fun insertPostsLocal(postsEntity: PostsEntity) = withContext(Dispatchers.IO){
        personDao.insertPostsLocal(postsEntity)
    }

    fun getListPostsLocal() = personDao.getPostsListLocal()

    fun getCountPersonLocal() = personDao.getCountPersonLocal()
}