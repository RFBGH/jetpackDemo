package com.example.rfb.jetpackdemo

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import com.example.rfb.jetpackdemo.activity_process.Activity0
import com.example.rfb.jetpackdemo.bottomsheet.BottomSheetActivity
import com.example.rfb.jetpackdemo.databinding.DataBindingActivity
import com.example.rfb.jetpackdemo.dialog.DialogCrashActivity
import com.example.rfb.jetpackdemo.mvvm.MvvmActivity
import com.example.rfb.jetpackdemo.navigation.NavigationActivity
import com.example.rfb.jetpackdemo.room.RoomActivity
import com.example.rfb.jetpackdemo.select_audio.SystemSelectFileActivity
import com.example.rfb.jetpackdemo.utils.ToastUtil
import com.example.rfb.jetpackdemo.view2bmp.View2BmpActivity
import kotlinx.android.synthetic.main.activity_main.*

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

        findViewById<View>(R.id.btn_crash_dialog)
                .setOnClickListener {
                    DialogCrashActivity.start(this)
                }

        findViewById<View>(R.id.btn_activity0)
                .setOnClickListener {
                    Activity0.start(this)
                }

        findViewById<View>(R.id.btn_select_audio)
                .setOnClickListener {
                    SystemSelectFileActivity.start(this)
                }

        findViewById<View>(R.id.btn_bottom_sheet)
                .setOnClickListener {
                    BottomSheetActivity.start(this)
                }

        findViewById<View>(R.id.btn_mvvm)
                .setOnClickListener {
                    MvvmActivity.start(this)
                }


        btn_view_2_bmp.setOnClickListener {
            View2BmpActivity.start(this)
        }
    }

}