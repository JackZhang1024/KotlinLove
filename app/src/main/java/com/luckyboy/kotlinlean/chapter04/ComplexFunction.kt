package com.luckyboy.kotlinlean.chapter04

/* 函数复合 */

val add5 = {i:Int -> i+5}

val multiplyBy2 = {i:Int->i*2}

fun main(args: Array<String>) {
    println(multiplyBy2(add5(8)))

    val add5AndMultiplyBy2 = add5 andThen multiplyBy2
    println(add5AndMultiplyBy2(8))


}

// 扩展函数 扩展了Function1函数
infix fun <P1, P2, R> Function1<P1, P2>.andThen(function:Function1<P2, R>):Function1<P1,R>{

    return fun(p1: P1):R{
        return function.invoke(this.invoke(p1))
    }

}