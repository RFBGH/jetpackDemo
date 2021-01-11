package com.example.rfb.jetpackdemo.utils

import android.content.Context
import android.widget.Toast

object ToastUtil{

    fun show(context: Context, msg : String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun show(context: Context, resId : Int){
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show()
    }
}