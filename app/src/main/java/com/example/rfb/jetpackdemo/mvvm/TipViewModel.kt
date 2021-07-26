package com.example.rfb.jetpackdemo.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rx.Observable
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class TipViewModel : ViewModel() {

    val tip = MutableLiveData<String>()

    fun load(){
        Observable
                .interval(1, TimeUnit.SECONDS)
                .take(5)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<Long>{
                    override fun onError(e: Throwable?) {
                    }

                    override fun onNext(t: Long?) {
                        tip.value = "time $t"
                    }

                    override fun onCompleted() {
                    }

                })

    }

}