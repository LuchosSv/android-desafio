package com.example.androidparadigma.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidparadigma.data.remote.PostsEntity

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

    //Local posts lists
    @Query("SELECT * FROM posts_table")
    fun getPostsListLocal(): LiveData<List<PostsEntity>>

    //Local, insert posts to local data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostsLocal(postsEntity: PostsEntity)

}