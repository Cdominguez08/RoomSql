package com.example.roomsql

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsql.entities.User

class UserRecyclerViewAdapter internal constructor() : RecyclerView.Adapter<UserRecyclerViewAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val userTextView : TextView = itemView.findViewById(R.id.txtUserName)
    }

    private var arrayList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_view_holder,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user : User = arrayList.get(position)
        holder.userTextView.text = user.firstName + ' ' + user.lastName
    }

    internal fun setUsers(userList : List<User>){
        arrayList = userList
        notifyDataSetChanged()
    }
}