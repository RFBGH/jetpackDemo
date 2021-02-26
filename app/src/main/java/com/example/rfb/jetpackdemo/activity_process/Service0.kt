package com.example.rfb.jetpackdemo.activity_process

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.text.TextUtils
import android.util.Log

class Service0 : Service() {

    companion object{
        val CMD = "cmd"
        fun start(context:Context, cmd:String){
            val it = Intent(context, Service0::class.java)
            it.putExtra(CMD, cmd)
            context.startService(it)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.e("flypig", "service $applicationContext")
        if(intent == null){
            return super.onStartCommand(intent, flags, startId)
        }

        val cmd = intent.getStringExtra(CMD)
        if(TextUtils.isEmpty(cmd)){
            return super.onStartCommand(intent, flags, startId)
        }

        Activity1.start(applicationContext)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}