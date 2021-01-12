package com.example.rfb.jetpackdemo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "student", indices = [Index(value = ["name"])])
class Student {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "name")
    var name = ""

    @ColumnInfo(name = "age")
    var age = 0

    @ColumnInfo(name = "sex")
    var sex = 0

    override fun toString(): String {
        return "id $id, name:$name, age:$age, sex:$sex"
    }
}

