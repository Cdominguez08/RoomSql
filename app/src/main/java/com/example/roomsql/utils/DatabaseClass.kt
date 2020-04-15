package com.example.roomsql.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomsql.R
import com.example.roomsql.entities.User
import com.example.roomsql.repository.UserDAO

@Database(entities = arrayOf(User::class),version = 1,exportSchema = false)
abstract class DatabaseClass : RoomDatabase(){

    abstract fun userDAO() : UserDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DatabaseClass? = null

        fun getDatabase(context: Context): DatabaseClass {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseClass::class.java,
                    context.getString(R.string.database_name)
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}