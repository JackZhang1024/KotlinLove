package com.luckyboy.kotlinlean.chapter06.lesson03

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/* 使用async的结构化并发 */
suspend fun doSomethingUsefulOnes():Int{
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwos():Int{
    delay(1000L)
    return 21
}


suspend fun concurrentSum():Int = coroutineScope {
    val one = async { doSomethingUsefulOnes() }
    val two = async { doSomethingUsefulTwos() }
    one.await()+two.await()
}


fun main()= runBlocking<Unit> {

    // 结构化一
//    val time = measureTimeMillis {
//        println("The answer is ${concurrentSum()}")
//    }
//    println("completed in $time ms")


    // 结构化二
    try {
        failecConcurrentSum()
    }catch (e:ArithmeticException){
        println("Computation with ArithmeticException ")
    }


}


// 取消始终通过协程的层次结构来进行传递
suspend fun failecConcurrentSum():Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MIN_VALUE)
            42
        }finally {
            println("First child was cancelled")
        }

    }
    val two = async<Int> {
        println("Second child was cancelled")
        throw ArithmeticException()
    }
    one.await()+two.await()

}