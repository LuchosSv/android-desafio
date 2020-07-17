package com.example.androidparadigma.data.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource (private val personDao: PersonDao){

    fun getPersonLocalList() = personDao.getPersonLocalList()

    suspend fun insertLocalPerson(userEntity: PersonEntity) = withContext(Dispatchers.IO) {
        personDao.insertLocalPerson(userEntity)
    }

}