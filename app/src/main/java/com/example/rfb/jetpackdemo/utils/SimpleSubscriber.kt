package com.example.rfb.jetpackdemo.utils

import rx.Subscriber
import java.util.concurrent.Flow

open class SimpleSubscriber<T> : Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}