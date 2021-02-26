package com.example.rfb.jetpackdemo.activity_process

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.rfb.jetpackdemo.R
import android.app.ActivityManager
import android.util.Log

class Activity2 : Activity() {

    companion object{
        fun start(activity: Context){
            val it = Intent(activity, Activity2::class.java)
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivity(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("flypig", "activity2 $applicationContext")

        setContentView(R.layout.activity2)

        findViewById<TextView>(R.id.btn_activity1).setOnClickListener {
            Activity1.start(this)
        }
    }

}