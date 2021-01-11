package com.example.rfb.jetpackdemo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name="name")
    var name = ""

    @ColumnInfo(name="age")
    var age = 0

    override fun toString(): String {
        return "id $id, name:$name, age:$age"
    }
}

