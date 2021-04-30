package com.example.rfb.jetpackdemo.bottomsheet

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.rfb.jetpackdemo.R
import com.example.rfb.jetpackdemo.utils.DisplayUtil


class InputDialog(context: Context) : Dialog(context, R.style.InputDialog) {

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

    lateinit var flContainer:FrameLayout
    lateinit var llPanel:LinearLayout
    lateinit var etInput:EditText
    var isInputOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.input_dialog)
        window?.setWindowAnimations(R.style.InputDialogAni)

        llPanel = findViewById(R.id.ll_panel)
        etInput = findViewById(R.id.et_input)
        etInput.requestFocus()

        flContainer = findViewById(R.id.fl_container)
        flContainer.rootView.viewTreeObserver.addOnGlobalLayoutListener {

            val out = Rect()
            llPanel.getGlobalVisibleRect(out)
            val offset = DisplayUtil.getScreenHeight(context) - out.bottom
            Log.e("flypig", "offset $offset")
            if(offset > 300){
                isInputOpen = true
                Log.e("flypig", "open")
            }else{

                if(isInputOpen){
                    dismiss()
                }

                Log.e("flypig", "close")
            }

        }
    }
}