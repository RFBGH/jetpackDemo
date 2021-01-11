package com.example.rfb.jetpackdemo.room

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.example.rfb.jetpackdemo.R
import com.example.rfb.jetpackdemo.utils.RxUtil
import rx.functions.Action0

class RoomActivity : Activity() {

    companion object{
        fun start(context:Context){
            val intent = Intent(context, RoomActivity::class.java)
            context.startActivity(intent)
        }
    }

    private fun getStudentDao():StudentDao{
        val dataBase = Room.databaseBuilder(applicationContext, DataBase::class.java, "room").build()
        return dataBase.studentDao()
    }

    private fun insert(){
        val studentDao = getStudentDao()

        val students = Array<Student>(10){
            val student = Student()
            student.name="name $it"
            student.age = it
            student
        }

        studentDao.insert(*students)
    }

    private fun queryAll(){
        val studentDao = getStudentDao()
        val students = studentDao.getAll()
        for(student in students){
            Log.e("flypig", student.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_room)

        findViewById<View>(R.id.btn_insert)
                .setOnClickListener {
                    RxUtil.runOnIo(Action0{
                        insert()
                    })

                }

        findViewById<View>(R.id.btn_query_all)
                .setOnClickListener {
                    RxUtil.runOnIo(Action0{
                        queryAll()
                    })
                }
    }

}