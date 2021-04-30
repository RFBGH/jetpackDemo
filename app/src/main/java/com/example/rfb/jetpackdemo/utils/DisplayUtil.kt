package com.example.rfb.jetpackdemo.utils

import android.content.Context

object DisplayUtil {

    fun getScreenHeight(context: Context):Int{
        return context.resources.displayMetrics.heightPixels
    }

    fun getScreenWidth(context: Context):Int{
        return context.resources.displayMetrics.widthPixels
    }
}