package com.luckyboy.kotlinlean.chapter04

import java.io.OutputStream


// 科利华

fun log(tag:String, target:OutputStream, message:Any?){
    target.write("[$tag] $message\n".toByteArray())
}


//fun log(tag:String)
//        =fun(target:OutputStream)
//        =fun(message:Any?)
//        =target.write("[$tag] $message\n".toByteArray())

fun main(args: Array<String>) {
    log("benny", System.out, "hello world")

//    log("benny")(System.out)("hello world")


    // 将一个函数变成科利华操作 ::log 函数引用
    ::log.curried()("benny")(System.out)("hello world again")


}


fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried() = fun(p1:P1)= fun (p2:P2)= fun (p3:P3) = this(p1, p2, p3)
