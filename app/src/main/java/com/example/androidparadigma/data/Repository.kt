package com.example.androidparadigma.data

import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonEntity

class Repository (private val localDataSource: LocalDataSource){

    fun getPersonLocalRepositoryList() = localDataSource.getPersonLocalList()

    suspend fun insertLocalRepositoryPerson(userEntity: PersonEntity) {
        localDataSource.insertLocalPerson(userEntity)
    }

}