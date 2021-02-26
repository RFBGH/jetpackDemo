package com.example.rfb.jetpackdemo.activity_process

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.rfb.jetpackdemo.R
import android.app.ActivityManager
import android.util.Log

class Activity1 : Activity() {

    companion object{
        fun start(activity: Context){
            val it = Intent(activity, Activity1::class.java)
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivity(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("flypig", "activity1 $applicationContext")

        setContentView(R.layout.activity1)

        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val info = manager.runningAppProcesses[0]

        findViewById<TextView>(R.id.iv_text).text = "${info.processName}"
    }

}