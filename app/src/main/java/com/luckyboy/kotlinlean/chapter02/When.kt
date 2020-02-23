package com.luckyboy.kotlinlean.chapter02



fun main(args: Array<String>) {

    val x = 5;
    when(x){
//        is Int-> println("Hello $x")
        in 1..100-> println("$x in 1..100")
        !in 1..100-> println("$x not in 1..100")
    }

    // when表达式 注意表达式的完整性
    val mode = when {
        x>6  ->10
        else ->0
    }
    println(mode)

}