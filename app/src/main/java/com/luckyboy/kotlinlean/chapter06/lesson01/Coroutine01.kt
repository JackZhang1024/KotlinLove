package com.luckyboy.kotlinlean.chapter06.lesson01

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(args: Array<String>) {

    croutine1()
}

fun croutine1(){
    // delay 是一个特殊的 挂起函数 它不会造成线程阻塞 但会挂起协程 并且只能在协程中使用
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) //非阻塞的等待 1秒钟（默认时间单位是毫秒）
        println("hello world")
    }
    println("hello ") // 协程已在等待时主线程还在继续
    Thread.sleep(2000) // 阻塞主线程2 秒钟保证 JVM存活
}

fun croutine2(){
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) //非阻塞的等待 1秒钟（默认时间单位是毫秒）
        println("hello world")
    }
    println("hello, ") // 协程已在等待时主线程还在继续
    runBlocking { // 这个表达式阻塞了主线程  调用runBlocing 的主线程会一直 阻塞到runBlocking 内部的协程执行完毕
        delay(2000) // 我们延迟了2秒来保证JVM的存活
    }



}