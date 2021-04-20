package com.example.rfb.jetpackdemo.bottomsheet

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.rfb.jetpackdemo.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CustomFragment :BottomSheetDialogFragment(){

    lateinit var etInput:EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.custom_bottom_sheet_dialog_fragment, container, false)
        etInput = view.findViewById(R.id.et_input)
        return view
    }

    override fun onStart() {
        super.onStart()

        //获取dialog对象
        val dialog = dialog as BottomSheetDialog?:return
        //把windowsd的默认背景颜色去掉，不然圆角显示不见
        dialog!!.window!!.findViewById<View>(R.id.design_bottom_sheet).setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //获取diglog的根部局
        //获取diglog的根部局
        val bottomSheet = dialog!!.delegate.findViewById<FrameLayout>(R.id.design_bottom_sheet)
        if (bottomSheet != null) {
            //获取根部局的LayoutParams对象
            val layoutParams = bottomSheet.layoutParams as CoordinatorLayout.LayoutParams
            layoutParams.height = getScreenHeight()
            //修改弹窗的最大高度，不允许上滑（默认可以上滑）
            bottomSheet.layoutParams = layoutParams
            val behavior = BottomSheetBehavior.from(bottomSheet)
            //peekHeight即弹窗的最大高度
            behavior.peekHeight = getPeekHeight()
            // 初始为展开状态
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED

            val param = etInput.layoutParams as FrameLayout.LayoutParams
            param.bottomMargin = bottomCollapseHeight()

            behavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    Log.e("flypig", "slideOffset $slideOffset")

                    param.bottomMargin = (bottomCollapseHeight()* (1-slideOffset)).toInt()
                    etInput.layoutParams = param
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    Log.e("flypig", "newState $newState")
                }

            })
        }
    }

    private fun bottomCollapseHeight():Int{
        return getScreenHeight()/3
    }

    private fun getScreenHeight():Int{
        return resources.displayMetrics.heightPixels
    }

    private fun getPeekHeight(): Int {
        val peekHeight = resources.displayMetrics.heightPixels
        //设置弹窗高度为屏幕高度的3/4
        return peekHeight - peekHeight / 3
    }

}