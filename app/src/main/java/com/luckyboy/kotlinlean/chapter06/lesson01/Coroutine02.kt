package com.luckyboy.kotlinlean.chapter06.lesson01

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main()= runBlocking<Unit> { //开始执行主协程

    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) //非阻塞的等待 1秒钟（默认时间单位是毫秒）
        println("hello world")
    }
    println("hello, ") // 主协程在这里会立即执行
    delay(2000) // 我们延迟了2秒来保证JVM的存活

}