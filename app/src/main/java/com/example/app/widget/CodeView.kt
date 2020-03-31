package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity

import com.example.app.R

import java.util.Random
import androidx.appcompat.widget.AppCompatTextView
import com.example.core.utils.dp2px


class CodeView /*主构造器*/ constructor(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {

    //kotlin 标准函数  apply 适合对一个对象做附加操作的时候
    private val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = context.getColor(R.color.colorAccent)
        strokeWidth = 6f.dp2px()
    }

    private val codeList = arrayOf("kotlin", "android", "java", "http", "https", "okhttp", "retrofit", "tcp/ip")

    //次级构造
    constructor(context: Context) : this(context, null)

    //主构造不能包含任何的代码，初始化代码可以放到 init 代码块中
    //在初始化的时候，初始化块会按照它们在「文件中出现的顺序」执行
     init{
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(context.getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)
        updateCode()

    }


    fun updateCode() {
        val random = Random().nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }


    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
        super.onDraw(canvas)
    }
}
