package com.luckyboy.kotlinlean.chapter03

abstract class Person(open var age:Int){

    abstract fun work()

}

class CodeFarmer(override var age: Int):Person(age){

    override fun work() {
        println("我是程序员 我在Coding...")
    }

}

class Doctor(override var age: Int):Person(age){

    override fun work() {
       println("我是医生 我在看病...")
    }

}


open class Animal{


}

// Animal 默认是final类型的 不能被继承 想要被继承 就要在class 前面加上open 关键字
// 默认的方法也是final的 想要被继承就需要加open 关键字
class Dog:Animal(){


}

fun main(args: Array<String>) {
    val person:Person = CodeFarmer(23)
    person.work()

    val doctor:Person = Doctor(22)
    doctor.work()

}


