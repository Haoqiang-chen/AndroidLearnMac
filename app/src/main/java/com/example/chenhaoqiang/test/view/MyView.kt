package com.example.chenhaoqiang.test.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val picture = Picture()

    init {
        recording()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            var paint = Paint()
            paint.style = Paint.Style.STROKE
            paint.color = Color.BLUE
            canvas.drawRect(0f, 0f, 250f, 250f, paint)
//        canvas?.drawPicture(picture)
            // draw ARC
            val rectF = RectF(0f, 0f, 500f, 500f)
            canvas.drawRect(rectF, paint)
            val arcPaint = Paint()
            arcPaint.color = Color.RED
            arcPaint.style = Paint.Style.FILL
            canvas.drawArc(rectF, 160f, 40f, false, arcPaint)
        }
    }

    private fun recording() {
        // 开始录制 (接收返回值Canvas)
        val canvas = picture.beginRecording(500, 500)
        // 创建一个画笔
        val paint = Paint()
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        canvas?.drawRect(0f, 0f, 250f, 250f, paint)

        // 在Canvas中具体操作
        // 位移
        canvas.translate(250f, 250f)
        // 绘制一个圆
        canvas.drawCircle(0f, 0f, 100f, paint)
        paint.strokeWidth = 5f
        paint.color = Color.RED
        canvas.drawPoint(0f, 0f, paint)

        picture.endRecording()
    }
}