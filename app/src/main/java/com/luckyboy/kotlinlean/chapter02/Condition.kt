package com.luckyboy.kotlinlean.chapter02


private const val DEBUG = 1;
private const val USER = 0;

fun main(args: Array<String>) {
    val mode = if (getName().isNotEmpty()) { // if 表达式
        USER
    } else {
        DEBUG
    }
    if (mode == USER) {
        println("进入用户模式");
    } else {
        println("进入工程模式");
    }
}


fun getName(): String {
    return ""
}

