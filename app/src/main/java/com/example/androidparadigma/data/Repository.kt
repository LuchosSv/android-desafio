package com.example.androidparadigma.data

import com.example.androidparadigma.data.local.LocalDataSource
import com.example.androidparadigma.data.local.PersonEntity

class Repository (private val localDataSource: LocalDataSource){

    fun getPersonLocalRepository() = localDataSource.getPersonLocal()

    suspend fun insertLocalRepositoryPerson(personEntity: PersonEntity) {
        localDataSource.insertLocalPerson(personEntity)
    }

    fun getCountPersonLocal() = localDataSource.getCountPersonLocal()

}