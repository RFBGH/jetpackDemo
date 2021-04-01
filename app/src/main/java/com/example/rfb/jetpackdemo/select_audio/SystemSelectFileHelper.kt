package com.example.rfb.jetpackdemo.select_audio

import android.app.Activity
import android.content.Intent
import android.widget.Toast


object SystemSelectFileHelper {

    const val ALL = "*/*"
    const val AUDIO = "audio/*"
    const val VIDEO = "video/*"
    const val IMAGE = "image/*"

    fun startSelectFile(activity:Activity, requestCode:Int, type:String){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = type //设置类型，我这里是任意类型，可以过滤文件类型
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        try{
            activity.startActivityForResult(intent, requestCode)
        }catch (e:Throwable){
            e.printStackTrace()
        }
    }
}