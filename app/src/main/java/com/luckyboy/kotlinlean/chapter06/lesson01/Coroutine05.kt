package com.luckyboy.kotlinlean.chapter06.lesson01

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 作用域构建器
// runBlocking 与 coroutineScope的主要区别在与后者在等待所有子协程执行完毕时不会阻塞当前线程
fun main()= runBlocking {

    launch {
        delay(2000L)
        println("Task from runBlocking")
    }

//    coroutineScope { // 创建一个协程作用域
//        launch {
//            delay(500L)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from corountine scope") // 这一行会在内嵌 launch 之前输出
//    }

    println("Coroutine scop is over") // 这一行在内嵌 launch 执行完毕后才输出

}