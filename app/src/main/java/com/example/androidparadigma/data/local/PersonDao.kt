package com.example.androidparadigma.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonDao {

    //Local person
    @Query("SELECT * FROM person_table")
    fun getPersonLocal(): LiveData<PersonEntity>

    //insert local person
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalPerson(userEntity: PersonEntity)

    //Count person
    @Query("SELECT COUNT(*) FROM person_table")
    fun getCountPersonLocal(): LiveData<Int>

}