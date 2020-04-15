package com.example.roomsql.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomsql.entities.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM USER")
    fun findAllUser() : LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createUser(user : User)

    @Delete()
    suspend fun deleteUser(user : User)
}