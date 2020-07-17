package com.example.androidparadigma.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 1, exportSchema = false)
abstract class PersonDatabase (): RoomDatabase(){

    abstract fun PersonDao(): PersonDao

    companion object {

        @Volatile
        private var INSTANCE: PersonDatabase? = null
        fun getInstance(context: Context): PersonDatabase {
            val tempInstan = INSTANCE
            if (tempInstan != null) {
                return tempInstan
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDatabase::class.java,
                    "person_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}