package com.luckyboy.kotlinlean.chapter03

import kotlin.reflect.KProperty

/* 成员变量代理 */

class Delegates{

    val hello by lazy {
        "hello wolrd"
    }

    val hello2 by X()

    // 一旦通过by来声明一个变量 实际就是一个傀儡 真正的实现是在代理的get方法中实现

    var hello3 by X()


}

// 代理对象需要实现set和get方法
class X{

     private var value:String?=null

     operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
         println("getValue: $thisRef->${property.name} ")
         return value ?: ""
     }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:String) {
        println("setValue: $thisRef->${property.name}=$value")
        this.value = value
    }


}


fun main(args: Array<String>) {
    val delegates = Delegates()
    println(delegates.hello)
    println(delegates.hello2)
    println(delegates.hello3)

    delegates.hello3 = "hello world value3"
    println(delegates.hello3)

}