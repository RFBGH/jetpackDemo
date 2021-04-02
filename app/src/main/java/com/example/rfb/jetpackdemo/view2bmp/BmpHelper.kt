package com.example.rfb.jetpackdemo.view2bmp

import android.graphics.*


object BmpHelper {

    fun getCircleBitmap(bitmap: Bitmap): Bitmap {

        try {
            val circleBitmap = Bitmap.createBitmap(bitmap.width,
                    bitmap.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(circleBitmap)
            val paint = Paint()
            val rect = Rect(0, 0, bitmap.width,
                    bitmap.height)
            val rectF = RectF(Rect(0, 0, bitmap.width,
                    bitmap.height))
            var roundPx = 0.0f
            // 以较短的边为标准
            roundPx = if (bitmap.width > bitmap.height) {
                bitmap.height / 2.0f
            } else {
                bitmap.width / 2.0f
            }
            paint.setAntiAlias(true)
            canvas.drawARGB(0, 0, 0, 0)
            paint.setColor(Color.WHITE)
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
            paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN))
            val src = Rect(0, 0, bitmap.width,
                    bitmap.height)
            canvas.drawBitmap(bitmap, src, rect, paint)
            return circleBitmap
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return bitmap
    }


}