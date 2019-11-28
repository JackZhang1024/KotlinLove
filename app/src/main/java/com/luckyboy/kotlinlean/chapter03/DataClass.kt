package com.luckyboy.kotlinlean.chapter03


/*
*  data class 有什么用
*  再见, JavaBean
*  默认实现的copy, toString 等方法
*  componentN 方法
*
*  data class 不适用于继承这种情况
*
* */
data class Country(var id:Int, var name:String)

fun main(args: Array<String>) {
    val china = Country(0, "中国")
    println(china)
    println(china.component1())
    println(china.component2())

    val (id, name)= china
    println(id)
    println(name)

    // withIndex
    val array:IntArray = intArrayOf(1, 2, 3, 5)
    for ((index, value) in array.withIndex()){
        println("$index $value")
    }



}