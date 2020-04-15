package com.example.roomsql.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "fist_name") var firstName : String?,
    @ColumnInfo(name = "last_name") val lastName : String?
)