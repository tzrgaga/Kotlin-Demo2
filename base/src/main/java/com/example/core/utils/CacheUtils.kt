package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

//object 单例
@SuppressLint("StaticFieldLeak")
object CacheUtils {

    private val context = BaseApplication.currentApplication

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    //函数简化
    fun save( key:String?,  value:String?) = SP.edit().putString(key, value).apply()

    //函数简化
    fun get(key:String):String? = SP.getString(key, null)
}