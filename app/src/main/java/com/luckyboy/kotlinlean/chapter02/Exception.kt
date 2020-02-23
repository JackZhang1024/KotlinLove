package com.luckyboy.kotlinlean.chapter02

import java.lang.Exception


fun main(args: Array<String>) {

    try {
        val arg = 10;
        val arg2 = 1;
        println(arg / arg2);
    } catch (e: Exception) {
        println("除数不能为零")
    } finally {
        println("欢迎您使用计算器")
    }

    // try 表达式
    val result = try {
        val arg = 10;
        val arg2= 0;
        println(arg/arg2)
    }catch (e:Exception){
        0
    }
    println(result)


}