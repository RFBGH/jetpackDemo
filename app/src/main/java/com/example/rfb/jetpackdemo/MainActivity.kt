package com.example.rfb.jetpackdemo

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import com.example.rfb.jetpackdemo.databinding.DataBindingActivity
import com.example.rfb.jetpackdemo.navigation.NavigationActivity
import com.example.rfb.jetpackdemo.room.RoomActivity
import com.example.rfb.jetpackdemo.utils.ToastUtil

@Keep
class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_test)
                .setOnClickListener {
                    ToastUtil.show(this, "test")
                }

        findViewById<View>(R.id.btn_databinding)
                .setOnClickListener {
                    DataBindingActivity.start(this)
                }

        findViewById<View>(R.id.btn_room)
                .setOnClickListener {
                    RoomActivity.start(this)
                }

        findViewById<View>(R.id.btn_navigation)
                .setOnClickListener {
                    NavigationActivity.start(this)
                }
    }

}