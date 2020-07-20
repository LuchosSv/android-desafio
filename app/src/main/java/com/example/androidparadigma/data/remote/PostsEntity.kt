package com.example.androidparadigma.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class PostsEntity(

    //autoGenerate = true
    val userId: Int,
    @PrimaryKey()
    val id: Int,
    val title: String,
    val body: String

)