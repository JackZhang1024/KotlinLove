package com.luckyboy.kotlinlean.chapter03

abstract class A {
    var i:Int = 0;

}

interface B{
    var j:Int;

}

interface C

abstract class E


class D(override var j:Int):A(),B,C{

}

// <联想><笔记本>电脑

fun main(args: Array<String>) {
    val d = D(0)

    if (d is A){

    }

    if (d is B){

    }


}