package com.example.rfb.jetpackdemo.dialog

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import com.example.rfb.jetpackdemo.R
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class TimerDialog(activity: Activity) :Dialog(activity){

    companion object{
        fun start(activity: Activity){
            val dialog = TimerDialog(activity)
            dialog.show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_timer)

        val tvCounter = findViewById<TextView>(R.id.tv_counter)
        Observable
                .interval(1, TimeUnit.SECONDS)
                .take(5)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object:Subscriber<Long>(){
                    override fun onNext(t: Long?) {
                        tvCounter.text = "$t"
                    }

                    override fun onCompleted() {
                        dismiss()
                    }

                    override fun onError(e: Throwable?) {
                        e?.printStackTrace()
                    }

                })
    }

}