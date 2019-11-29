package com.luckyboy.kotlinlean.chapter06.lesson01

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*  结构化的并发 这种情况下不需要 显式的使用join来等待作用域内的协程结束 */

fun main() = runBlocking {

    launch {
        delay(1000)
        println("wolrd")
    }
    println("hello")

}

