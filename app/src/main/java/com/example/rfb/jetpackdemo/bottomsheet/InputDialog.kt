package com.example.rfb.jetpackdemo.bottomsheet

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import com.example.rfb.jetpackdemo.R


class InputDialog(context: Context) : Dialog(context) {

    companion object{

        fun show(context: Activity){

            val inputDialog = InputDialog(context)
            inputDialog.show()

            val window = inputDialog.window
            val layoutParams: WindowManager.LayoutParams = window?.attributes ?:return
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
            layoutParams.horizontalMargin = 0f
            layoutParams.verticalMargin = 0f
            window.attributes = layoutParams
            window.decorView.minimumWidth = context.resources.displayMetrics.widthPixels
            window.decorView.setPadding(0, 0, 0, 0)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.input_dialog)
    }
}