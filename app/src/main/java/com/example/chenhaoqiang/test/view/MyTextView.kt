package com.example.chenhaoqiang.test.view

import android.content.Context
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.support.annotation.RequiresApi
import android.text.*
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.widget.TextView
import com.example.chenhaoqiang.test.R

class MyTextView : TextView {
//    private val typeArray = context?.obtainStyledAttributes(attrs, R.styleable.MyTextView)
//    private val ellipsis = typeArray?.getString(R.styleable.MyTextView_ellipsis)
//
//    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        val lines = layout.lineCount
//        if (lines < 2) {
//            return
//        }
//        if (layout.getEllipsisCount(lines - 1) == 0) {
//            return
//        }
//
//        System.out.print(layout.getLineVisibleEnd(maxLines))
//        val ellipsWidth = getTextWidth("...全部")
//
//        val lastLineText = text.substring(layout.getLineStart(lines - 1), text.length)
//        val staticLayout = StaticLayout(lastLineText,
//                layout.paint, layout.width, layout.alignment,
//                layout.spacingMultiplier, layout.spacingAdd, false)
//
//        text = text.substring(0, layout.getLineStart(lines - 1) + staticLayout.getLineEnd(0)-6) + ellipsis
//    }
//
//    private fun getTextWidth(text: String): Int {
//        val bounds = Rect()
//        paint.getTextBounds(text, 0, text.length, bounds)
//        return bounds.width()
//    }

    constructor(context: Context?) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    private val attrs = this.att
    private var typeArray = context?.obtainStyledAttributes(attributeSet, R.styleable.MyTextView)
    private var ellipsis = typeArray?.getString(R.styleable.MyTextView_ellipsis)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    private var limitLines: Int = this.maxLines

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 若文本长度小于被限制的行数则不需要显示省略号
        val lines = layout.lineCount
        if (lines < limitLines) {
            return
        }
        // 若无被省略的字符则不需要显示省略号
        if (layout.getEllipsisCount(lines - 1) == 0) {
            return
        }
        ellipsis?.let {
            val ellipsisWidth = getTextWidth(it)
            // 获取最后一行文字
            val lastLineText = text.substring(layout.getLineStart(lines - 1), text.length)
            // 根据layout的宽度和自定义省略号的宽度来获取能显示的文字
            val staticLayout = StaticLayout(lastLineText, layout.paint, layout.width - ellipsisWidth, layout.alignment, layout.spacingMultiplier, layout.spacingAdd, false)
            // 根据最后一行能显示的文字来截取并拼接文本
            text = text.substring(0, layout.getLineStart(lines - 1) + staticLayout.getLineEnd(0)) + it
        }
    }

    // 获取文字宽度
    private fun getTextWidth(text: String): Int {
        val bounds = Rect()
        paint.getTextBounds(text, 0, text.length, bounds)
        return bounds.width()
    }


}