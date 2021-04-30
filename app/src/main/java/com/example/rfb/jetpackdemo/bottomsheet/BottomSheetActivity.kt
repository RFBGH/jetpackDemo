package com.example.rfb.jetpackdemo.bottomsheet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.example.rfb.jetpackdemo.R

class BottomSheetActivity : FragmentActivity() {

    companion object{

        fun start(activity: Activity){
            val it = Intent(activity, BottomSheetActivity::class.java)
            activity.startActivity(it)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bottom_sheet)

        findViewById<Button>(R.id.btn_start)
                .setOnClickListener {
                    CustomFragment().show(supportFragmentManager, "test")
                }

        findViewById<Button>(R.id.btn_input_dialog)
                .setOnClickListener {
                    InputDialog.show(this)
                }
    }

}