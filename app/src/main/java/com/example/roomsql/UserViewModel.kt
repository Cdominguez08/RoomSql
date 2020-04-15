package com.example.roomsql

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomsql.entities.User
import com.example.roomsql.repository.UserRepository
import com.example.roomsql.utils.DatabaseClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository : UserRepository

    val allUsers : LiveData<List<User>>

    init {
        val userDAO = DatabaseClass.getDatabase(application).userDAO()
        userRepository = UserRepository(userDAO)
        allUsers = userRepository.allUsers
    }

    fun createUser(user : User) = viewModelScope.launch(Dispatchers.IO){
        userRepository.createUser(user)
    }

    fun deleteUser(user : User) = viewModelScope.launch(Dispatchers.IO){
        userRepository.deleteUser(user)
    }
}