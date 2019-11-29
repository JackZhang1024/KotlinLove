package com.luckyboy.kotlinlean.chapter06.lesson02

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/* 超时机制 */

fun main()= runBlocking {

    // 会出现超时问题
//    withTimeout(1300L){
//        repeat(1000){i->
//            println("I'm sleeping $i")
//            delay(500L)
//        }
//    }


    // 不会出现超时问题
    val result = withTimeoutOrNull(1300L){
        repeat(1000){i->
            println("I'm sleeping $i")
            delay(500L)
        }
    }
    println("Result is $result")


}