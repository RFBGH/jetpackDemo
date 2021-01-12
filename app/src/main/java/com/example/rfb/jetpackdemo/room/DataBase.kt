package com.example.rfb.jetpackdemo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Student::class], version = 2)
abstract class DataBase :RoomDatabase(){

    companion object{

        private val migration1_2 = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table student add column sex integer not null default '0'")
            }
        }

        private var instance:DataBase? = null

        fun getDataBase(context: Context):DataBase{
            if(instance == null){
                synchronized(DataBase::class.java){
                    if(instance == null){
                        instance = Room
                                .databaseBuilder(context.applicationContext, DataBase::class.java, "room")
                                .addMigrations(migration1_2)
                                .build()
                    }
                }
            }
            return instance!!
        }

    }

    abstract fun studentDao():StudentDao
}