package com.luckyboy.kotlinlean

import com.luckyboy.kotlinlean.chapter03.times

open class Parent(var name: String) {

    open fun sayHi() {
        println("parent $name say hello")
    }

}

class Child(name: String, age: Int) : Parent(name) {

    override fun sayHi() {
        println("child $name say hello")
    }
}


fun main() {
    val childOne: Parent = Child("Bruce Li", 12)
    if (childOne is Parent) {

    }
    if (childOne is Child) {
        childOne.sayHi()
    }
    val childTwo: Parent = Parent("Bruce Li")
    if (childTwo is Parent) {
        childTwo.sayHi()
    }
    if (childTwo is Child) {
        childTwo.sayHi()
    }
    val childThree: Parent = Child("Bruce John", 10)
    val childTFour: Child = childThree as Child
    childTFour.sayHi()

    // Exception in thread "main" java.lang.ClassCastException: com.luckyboy.kotlinlean.Parent cannot be cast to com.luckyboy.kotlinlean.Child
//    val childFive:Child = childTwo as Child // 不安全的类型转换
    val childFive: Child? = childTwo as? Child // 安全的类型转换
    childFive?.sayHi() // childFive为null 就不执行了 sayHi方法


}