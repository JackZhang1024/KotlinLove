package com.luckyboy.kotlinlean.chapter02



fun main(args: Array<String>) {
    hello(1,23,3,4, string = "hello world")
    val array = intArrayOf(1,3,4, 5)
    hello(*array, string="hello world") // *array 表示展开数组array *不能展开其他
    hello(*array) // *array 表示展开数组array *不能展开其他
}

// string 具名参数 string:String="hello universe"
fun hello(vararg ints:Int, string:String="hello universe"){
    ints.forEach(::println)
    println(string)
}

// 默认参数
