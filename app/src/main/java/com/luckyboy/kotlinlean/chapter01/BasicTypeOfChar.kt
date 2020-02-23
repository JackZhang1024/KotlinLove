package com.luckyboy.kotlinlean.chapter01

val aChar:Char = '0';
val bChar:Char = '中';
val cChar:Char = '\u000f';




/* 不可隐式转换 只能进行如下操作
*  val anInt:Int = 5;
*  val aLong:Long = anInt.toLong();
*
*  */
fun main(args: Array<String>) {

    println(aChar);
    println(bChar);
    println(cChar);



}