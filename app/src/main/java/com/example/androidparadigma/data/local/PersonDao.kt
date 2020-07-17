package com.example.androidparadigma.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonDao {

    //List local person
    @Query("SELECT * FROM person_table")
    fun getPersonLocalList(): LiveData<List<PersonEntity>>

    //insert local person
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalPerson(userEntity: PersonEntity)

}