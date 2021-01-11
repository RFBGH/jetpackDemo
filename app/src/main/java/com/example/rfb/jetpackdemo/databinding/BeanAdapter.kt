package com.example.rfb.jetpackdemo.databinding

import android.widget.TextView
import androidx.databinding.BindingAdapter


object BeanAdapter {

    @JvmStatic
    @BindingAdapter("bindContent")
    fun bindContent2(tvContent:TextView, bean : Bean){
        tvContent.text=bean.getContent()+" 2222"
    }

}