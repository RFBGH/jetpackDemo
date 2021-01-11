package com.example.rfb.jetpackdemo.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class DataBase :RoomDatabase(){

    abstract fun studentDao():StudentDao
}