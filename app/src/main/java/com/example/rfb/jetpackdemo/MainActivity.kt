package com.example.rfb.jetpackdemo

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
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
    }

}