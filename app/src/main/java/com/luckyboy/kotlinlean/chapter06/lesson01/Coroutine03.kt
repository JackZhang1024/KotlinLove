package com.luckyboy.kotlinlean.chapter06.lesson01

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/* 等待一个作业
*  延迟一段时间来等待另一个协程运行并不是一个好的选择
*  我们可以选择显式（以非阻塞方式）等待所启动的后台job执行结束
*
*  下面这个例子是Croutine02的升级版本
*
*  */
fun main()= runBlocking<Unit> {

    val job = GlobalScope.launch {
        delay(1000)
        println("hello world")
    }
    println("hello ")
    job.join()


}

