package com.luckyboy.kotlinlean.chapter06.lesson03

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/* 挂起函数的各种组合 */

suspend fun doSomethingUsefulOne():Int{
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo():Int{
    delay(1000L)
    return 21
}

// 按照顺序执行的
//fun main()= runBlocking {
//    val time = measureTimeMillis {
//        val one = doSomethingUsefulOne()
//        val two = doSomethingUsefulTwo()
//        println("The answer is ${one+two}")
//    }
//    println("completed in $time ms")
//
//}


// 使用async并发 如果doSomethingUsefulOne和doSomethingUsefulTwo 之间没有依赖
// 并且我们想更快的得到结果 并发操作可以吗
// async 类似于 launch 它启动了一个单独的协程，这是一个轻量级的线程并与其他的协程一块并发的工作
// The answer is 34
// completed in 1022 ms
// 这块明显看到时间缩短了 原因是两个协程并发执行 注意 使用协程进行并发操作总是显式的

//fun main()= runBlocking {
//    val time = measureTimeMillis {
//        val one = async { doSomethingUsefulOne() }
//        val two = async { doSomethingUsefulTwo() }
//        println("The answer is ${one.await()+two.await()}")
//    }
//    println("completed in $time ms")
//}

// 惰性启动的 async 如果没有调用start方法 就会变成顺序执行 不是并发执行
fun main()= runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        // 执行一些操作
        one.start()
        two.start()
        println("The answer is ${one.await()+two.await()}")
    }
    println("completed in $time ms")
}
