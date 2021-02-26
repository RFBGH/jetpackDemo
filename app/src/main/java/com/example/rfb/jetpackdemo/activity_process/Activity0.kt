package com.example.rfb.jetpackdemo.activity_process

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.rfb.jetpackdemo.R

class Activity0 : Activity() {

    companion object{
        fun start(activity: Activity){
            val it = Intent(activity, Activity0::class.java)
            activity.startActivity(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("flypig", "activity0 $applicationContext")

        setContentView(R.layout.activity0)

        findViewById<Button>(R.id.btn_test).setOnClickListener {
            Service0.start(this, "")
        }

        findViewById<Button>(R.id.btn_test1).setOnClickListener {
            Service0.start(this, "cmd")
        }

        findViewById<Button>(R.id.btn_start_activity2).setOnClickListener {
            Activity2.start(this)
        }
    }

}