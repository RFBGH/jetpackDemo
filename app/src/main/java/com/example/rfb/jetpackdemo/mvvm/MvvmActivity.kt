package com.example.rfb.jetpackdemo.mvvm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rfb.jetpackdemo.R

class MvvmActivity : AppCompatActivity() {

    companion object{
        fun start(activity:Activity){
            val it = Intent(activity, MvvmActivity::class.java)
            activity.startActivity(it)
        }
    }

    val tipViewModel:TipViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mvvm)

        findViewById<View>(R.id.btn_test).setOnClickListener {
            tipViewModel.load()
        }

        val tip = findViewById<TextView>(R.id.tv_tip)
        tipViewModel.tip.observe(this, object :Observer<String>{
            override fun onChanged(t: String?) {
                tip.text = t
            }
        })
    }

}