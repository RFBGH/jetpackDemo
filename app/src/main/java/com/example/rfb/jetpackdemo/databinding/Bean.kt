package com.example.rfb.jetpackdemo.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.example.rfb.jetpackdemo.BR

class Bean(content : String) : BaseObservable() {

    private var mContent = content
    private var mutableContent = MutableLiveData<String>()

    fun setContent(content: String){
        mContent = content
        notifyPropertyChanged(BR.content)
    }

    @Bindable
    fun getContent():String{
        return mContent
    }

    fun getMutableContent() : MutableLiveData<String>{
        return mutableContent
    }

    fun updateMutContent(mutContent : String){
        mutableContent.value = mutContent
    }

}