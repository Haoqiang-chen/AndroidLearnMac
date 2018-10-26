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

class MyTextView(context: Context?, attrs: AttributeSet?) : TextView(context, attrs) {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val lines = layout.lineCount
        if (lines < 2) {
            return
        }
        if (layout.getEllipsisCount(lines - 1) == 0) {
            return
        }
        System.out.print(layout.getLineVisibleEnd(maxLines))
        val ellipsWidth = getTextWidth("...全部")

        val lastLineText = text.substring(layout.getLineStart(lines - 1), text.length)
        val staticLayout = StaticLayout(lastLineText,
                layout.paint, layout.width, layout.alignment,
                layout.spacingMultiplier, layout.spacingAdd, false)

        text = text.substring(0, layout.getLineStart(lines - 1) + staticLayout.getLineEnd(0)-6) + "...全部"
    }

    private fun getTextWidth(text: String): Int {
        val bounds = Rect()
        paint.getTextBounds(text, 0, text.length, bounds)
        return bounds.width()
    }


}