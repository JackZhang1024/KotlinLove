package com.luckyboy.kotlinlean.chapter03

import java.lang.StringBuilder

/* 扩展成员 */
fun main(args: Array<String>) {
    println("abc".multiply(10))
    println("abc"*10)
    println("123".a)
    "abc".b = 200
    println("abc".b)

}

// 运算符重载 扩展方法
operator fun String.times(int:Int):String{
    val stringBuilder = StringBuilder()
    for (i in 0 until int){
        stringBuilder.append(this);
    }
    return stringBuilder.toString()
}

fun String.multiply(int:Int):String{
    val stringBuilder = StringBuilder()
    for (i in 0 until int){
         stringBuilder.append(this);
    }
    return stringBuilder.toString()

}

// 给String类加一个名称为a的属性
val String.a:String
        get() = "abc"

//
var String.b:Int
   set(value) {

   }

   get() = 10

