package com.example.rfb.jetpackdemo.view2bmp

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View

object View2BmpHelper {

    fun view2Bmp(v: View):Bitmap{

        val w = v.width
        val h = v.height

        val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val c = Canvas(bmp)

        //不设置canvas颜色，则生成透明背景
        //c.drawColor(Color.WHITE);
        v.draw(c)

        return bmp
    }

}