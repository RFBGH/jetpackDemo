package com.example.rfb.jetpackdemo.view2bmp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.rfb.jetpackdemo.R
import com.example.rfb.jetpackdemo.utils.SimpleSubscriber
import kotlinx.android.synthetic.main.activity_view2bmp.*
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class View2BmpActivity :Activity(){

    companion object{
        fun start(context:Context){
            val it = Intent(context, View2BmpActivity::class.java)
            context.startActivity(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view2bmp)

        btnTestViewInWindow.setOnClickListener {
            ivContent.setImageDrawable(BitmapDrawable(View2BmpHelper.view2Bmp(btnTestViewInWindow)))
        }

        btnTestViewNoInWindow.setOnClickListener {
            testLayout2Bmp()
        }
    }

    //然后View和其内部的子View都具有了实际大小，也就是完成了布局，相当与添加到了界面上。接着就可以创建位图并在上面绘制了：
    private fun layoutView(v: View, width: Int, height: Int) {
        // 整个View的大小 参数是左上角 和右下角的坐标
        v.layout(0, 0, width, height)
        val measuredWidth: Int = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY)
        val measuredHeight: Int = View.MeasureSpec.makeMeasureSpec(10000, View.MeasureSpec.AT_MOST)
        /** 当然，measure完后，并不会实际改变View的尺寸，需要调用View.layout方法去进行布局。
         * 按示例调用layout函数后，View的大小将会变成你想要设置成的大小。
         */
        v.measure(measuredWidth, measuredHeight)
        v.layout(0, 0, v.measuredWidth, v.measuredHeight)
    }

    private fun testLayout2Bmp(){

        val metric = DisplayMetrics() //获取屏幕
        windowManager.defaultDisplay.getMetrics(metric) //是获取到Activity的实际屏幕信息。

        Observable
                .create(Observable.OnSubscribe<Bitmap> { t ->
                    val width = metric.widthPixels // 屏幕宽度（像素）
                    val height = metric.heightPixels // 屏幕高度（像素）

                    val view = LayoutInflater.from(this@View2BmpActivity).inflate(R.layout.layout_test, null)
                    val iv = view.findViewById<ImageView>(R.id.iv_icon)

                    var avatar = BitmapFactory.decodeResource(resources, R.drawable.test)
                    avatar = BmpHelper.getCircleBitmap(avatar)
                    iv.setImageDrawable(BitmapDrawable(avatar))
                    layoutView(view, width, height)
                    t.onNext(View2BmpHelper.view2Bmp(view))
                    t.onCompleted()
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :SimpleSubscriber<Bitmap>(){
                    override fun onNext(t: Bitmap) {
                        ivContent.setImageDrawable(BitmapDrawable(t))
                    }
                })
    }


}