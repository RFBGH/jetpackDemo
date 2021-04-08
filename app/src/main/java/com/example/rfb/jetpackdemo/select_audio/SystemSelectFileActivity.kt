package com.example.rfb.jetpackdemo.select_audio

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.rfb.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_system_select_file.*
import java.lang.StringBuilder

class SystemSelectFileActivity : Activity() {

    companion object{
        fun start(context: Context){
            val it = Intent(context, SystemSelectFileActivity::class.java)
            context.startActivity(it);
        }
    }

    lateinit var tvAudioContent:TextView
    lateinit var btnSelectAudio:Button

    lateinit var tvFileContent:TextView
    lateinit var btnSelectFile:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_system_select_file)
        tvAudioContent = findViewById(R.id.tv_audio_content)
        btnSelectAudio = findViewById(R.id.btn_select_audio)

        tvFileContent = findViewById(R.id.tv_file_content)
        btnSelectFile = findViewById(R.id.btn_select_file)

        btnSelectAudio.setOnClickListener {
            SystemSelectFileHelper.startSelectFile(this, 100, SystemSelectFileHelper.AUDIO)
        }

        btnSelectFile.setOnClickListener {
            SystemSelectFileHelper.startSelectFile(this, 101, SystemSelectFileHelper.ALL)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode != RESULT_OK){
            return
        }

        if(data == null){
            return
        }

        val sb = StringBuilder(data.data?.toString())
        sb.append("\r\n")
        val fileInfo = ContentProviderHelper.getFileInfo(this, data.data?: Uri.EMPTY)
        sb.append("name:${fileInfo.name}")
        sb.append("\r\n")
        sb.append("size:${fileInfo.size}")

        if(requestCode == 100){
            tvAudioContent.text = sb.toString()
        }

        if(requestCode == 101){
            tvFileContent.text = sb.toString()
        }

    }


}