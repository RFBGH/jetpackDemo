package com.example.rfb.jetpackdemo.view2bmp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import com.example.rfb.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_view2bmp.*

class View2BmpActivity :Activity(){

    companion object{
        fun start(context:Context){
            val it = Intent(context, View2BmpActivity::class.java)
            context.startActivity(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view2bmp)

        btnTestViewInWindow.setOnClickListener {
            ivContent.setImageDrawable(BitmapDrawable(View2BmpHelper.view2Bmp(btnTestViewInWindow)))
        }

        btnTestViewNoInWindow.setOnClickListener {

        }
    }



}