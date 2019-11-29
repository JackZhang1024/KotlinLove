package com.luckyboy.kotlinlean.chapter06.lesson02

import kotlinx.coroutines.*

/* 取消协程 */

fun main()= runBlocking {

    val job = launch {
        repeat(1000){i->
            println("job: I'am sleeping $i")
            delay(500L)
        }
    }

    delay(5000L)
    println("main: I'm tired of waiting!")
    //job.cancel() // 取消作业
    //job.join() // 等待作业执行结束
    job.cancelAndJoin() // job.cancel job.join 的替换方法
    println("main: Now I can quit.")



}