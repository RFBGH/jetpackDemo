package com.example.rfb.jetpackdemo.dialog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.rfb.jetpackdemo.R
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class DialogCrashActivity :Activity(){

    companion object{
        fun start(activity: Activity){
            val intent = Intent(activity, DialogCrashActivity::class.java)
            activity.startActivity(intent);
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dialog)

        findViewById<View>(R.id.btn_test).setOnClickListener {
            test()
        }
    }

    private fun test(){
        Observable
                .timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object:Subscriber<Long>(){
                    override fun onNext(t: Long?) {
                        finish()
                    }

                    override fun onCompleted() {
                    }

                    override fun onError(e: Throwable?) {
                        e?.printStackTrace()
                    }
                })

        TimerDialog.start(this)
    }


}