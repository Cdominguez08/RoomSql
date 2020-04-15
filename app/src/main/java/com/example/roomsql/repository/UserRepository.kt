package com.example.roomsql.repository

import androidx.lifecycle.LiveData
import com.example.roomsql.entities.User

class UserRepository(private val userDAO: UserDAO) {

    val allUsers : LiveData<List<User>> = userDAO.findAllUser();

    suspend fun createUser(user : User){
        userDAO.createUser(user)
    }

    suspend fun deleteUser(user : User){
        userDAO.deleteUser(user)
    }
}