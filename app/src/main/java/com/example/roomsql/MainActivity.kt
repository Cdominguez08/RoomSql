package com.example.roomsql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsql.entities.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG : String = "RoomSQL"
    private lateinit var userViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewUser = findViewById<RecyclerView>(R.id.rvUser)
        val adapter = UserRecyclerViewAdapter()



        recyclerViewUser.adapter = adapter
        recyclerViewUser.layoutManager = LinearLayoutManager(this)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.allUsers.observe(this, Observer {
            userList -> userList?.let { adapter.setUsers(it) }
        })

        btnInsertUser.setOnClickListener({
            createUser()
        })

        btnDeleteUser.setOnClickListener({
            deleteUser()
        })
    }

    private fun createUser() {

        val user = User(firstName = "C.", lastName = "Dominguez",id = 0)
        userViewModel.createUser(user)
    }

    fun deleteUser(){

        var index = (userViewModel.allUsers.value?.size ?: 0) - 1

        if(index >= 0){

            val userToDelete = userViewModel.allUsers.value?.get(index)
            userToDelete?.let { userViewModel.deleteUser(it) }
        }
    }
}
