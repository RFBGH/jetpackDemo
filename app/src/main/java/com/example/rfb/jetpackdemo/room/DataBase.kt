package com.example.rfb.jetpackdemo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class DataBase :RoomDatabase(){

    companion object{

        private var instance:DataBase? = null

        fun getDataBase(context: Context):DataBase{
            if(instance == null){
                synchronized(DataBase::class.java){
                    if(instance == null){
                        instance = Room.databaseBuilder(context.applicationContext, DataBase::class.java, "room").build()
                    }
                }
            }
            return instance!!
        }

    }

    abstract fun studentDao():StudentDao
}