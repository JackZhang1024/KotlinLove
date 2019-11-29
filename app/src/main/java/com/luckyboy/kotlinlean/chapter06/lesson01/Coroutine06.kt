package com.luckyboy.kotlinlean.chapter06.lesson01

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 提取函数重构

fun main()= runBlocking {

    launch {
        doWorld()
    }

    println("Hello ")
}

// 挂起程序
suspend fun doWorld(){
    delay(1000L)
    println("world")
}



