package com.example.core

interface BaseView<T> {

//    fun getPresenter(): T
    //抽象属性
    //在 Kotlin 中，我们可以声明抽象属性，子类对抽象属性重写的时候需要重写对应的 setter/getter
    val presenter: T

}