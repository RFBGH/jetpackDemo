package com.example.rfb.jetpackdemo.select_audio

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import java.io.File

data class FileInfo(val name:String, val size:Long)

object ContentProviderHelper {

    fun getFileInfo(context: Context, uri:Uri):FileInfo{

        if(ContentResolver.SCHEME_FILE == uri.scheme){

            val file = File(uri.path?:"")
            return FileInfo(file.name, file.length())
        }else{
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            if(cursor != null && cursor.moveToFirst()){
                val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)
                var length = 0L
                if(!cursor.isNull(sizeIndex)){
                    length = cursor.getLong(sizeIndex)
                }

                var name = ""
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if(!cursor.isNull(nameIndex)){
                    name = cursor.getString(nameIndex)
                }

                return  FileInfo(name, length)
            }

            return FileInfo("", 0)
        }
    }

}