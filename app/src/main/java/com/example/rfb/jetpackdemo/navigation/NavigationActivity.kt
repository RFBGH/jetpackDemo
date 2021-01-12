package com.example.rfb.jetpackdemo.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.rfb.jetpackdemo.R

class NavigationActivity :AppCompatActivity(){

    companion object{

        fun start(context : Context){
            val intent = Intent(context, NavigationActivity::class.java)
            context.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_navigation)

        val navHostView  = findViewById<View>(R.id.nav_host_fragment)
        val navController = Navigation.findNavController(navHostView)

        findViewById<View>(R.id.btn_test)
                .setOnClickListener {
                    navController.navigate(R.id.destination_activity)
                }

        findViewById<View>(R.id.btn_uri)
                .setOnClickListener {
                    navController.navigate(Uri.parse("http://activity/destination_activity"))
                }
    }

}