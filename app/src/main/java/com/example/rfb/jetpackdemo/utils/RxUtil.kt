package com.example.rfb.jetpackdemo.utils

import rx.Observable
import rx.functions.Action0
import rx.schedulers.Schedulers

object RxUtil {

    fun runOnIo(action0: Action0) {

        Observable
                .create(Observable.OnSubscribe<Void> {
                    action0.call()
                    it.onCompleted()
                })
                .subscribeOn(Schedulers.io())
                .subscribe(object:SimpleSubscriber<Void>(){})

    }
}