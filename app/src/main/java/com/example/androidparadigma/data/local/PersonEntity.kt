package com.example.androidparadigma.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class PersonEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "personId")
    val id: Int = 0,
    val nombre: String,
    val apellido: String,
    val ocupacion: String,
    val nacimiento: String

)