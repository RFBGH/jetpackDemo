package com.example.rfb.jetpackdemo.databinding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.rfb.jetpackdemo.R
import java.util.*

class DataBindingActivity : AppCompatActivity(){

    companion object{

        fun start(context : Context){
            val intent = Intent(context, DataBindingActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contentView = DataBindingUtil.setContentView<ActivityDatabindingBinding>(this, R.layout.activity_databinding)
        setContentView(contentView.root)
        val bean = Bean("flypig")
        contentView.bean = bean

        findViewById<View>(R.id.btn_update)
                .setOnClickListener {
                    bean.setContent("update "+random.nextInt())
                    bean.updateMutContent("mut update "+random.nextInt())
                }

        bean.getMutableContent()
                .observe(this, androidx.lifecycle.Observer<String> {
                    findViewById<TextView>(R.id.tv_mut_content).text = it
                })

        lifecycle.addObserver(object: LifecycleEventObserver{
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {

                Log.e("flypig", "${source} $event")

            }

        })

    }

}