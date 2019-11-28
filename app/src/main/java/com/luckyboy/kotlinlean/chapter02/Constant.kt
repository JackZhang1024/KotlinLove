package com.luckyboy.kotlinlean.chapter02

// val 尽管不可变 但是还是不是编译器常量 如果要是编译器常量 则要在val前面加上 const

val FINAL_HELLO_WORLD: String = "Hello Wolrd";
const val FINAL_HELLO_UNIVERse = "Hello universe";

var helloWorld: String = "Hello World";

// 类型推导
val FINAL_HELLO_CHINA = "Hello China";

fun main(args: Array<String>) {
    println(helloWorld);
    helloWorld = "Hello China";
    println(helloWorld);
    println(FINAL_HELLO_CHINA);


}