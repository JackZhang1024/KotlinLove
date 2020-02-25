package com.luckyboy.kotlinlean

import com.luckyboy.kotlinlean.chapter03.times
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

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
//    val childOne: Parent = Child("Bruce Li", 12)
//    if (childOne is Parent) {
//
//    }
//    if (childOne is Child) {
//        childOne.sayHi()
//    }
//    val childTwo: Parent = Parent("Bruce Li")
//    if (childTwo is Parent) {
//        childTwo.sayHi()
//    }
//    if (childTwo is Child) {
//        childTwo.sayHi()
//    }
//    val childThree: Parent = Child("Bruce John", 10)
//    val childTFour: Child = childThree as Child
//    childTFour.sayHi()
//
//    // Exception in thread "main" java.lang.ClassCastException: com.luckyboy.kotlinlean.Parent cannot be cast to com.luckyboy.kotlinlean.Child
////    val childFive:Child = childTwo as Child // 不安全的类型转换
//    val childFive: Child? = childTwo as? Child // 安全的类型转换
//    childFive?.sayHi() // childFive为null 就不执行了 sayHi方法
//
//    val person = Person().apply {
//        age = 20
//        gender = "female"
//        look = "good"
//        voice = "sweet"
//        println(this)
//    }
//
//    val person2 = with(person){
//        "112"
//        1
//    }
//    println(person2)
//
//
//    val file = File("Hello.txt")
//    if (!file.exists()){
//        println("文件不存在")
//        return
//    }
//    println("file ${file.absolutePath}")
//    val bufferReader = BufferedReader(FileReader(file))
//    bufferReader.use {
//        it.readLines().forEach {
//            println(it)
//        }
//    }

    val mapOne = mapOf(100 to "Jack", 101 to "Rose", 102 to "Lily")
    val mapTwo = mapOf<Int, String>()
    val mapThree = mapOf(10 to 200)

    println(mapOne.size)
    println(mapOne[100])
    println(mapOne.containsKey(100))
    // 遍历所有的key
    for (key in mapOne.keys) {
        println("key=${key} - value = ${mapOne[key]}")
    }

    // 遍历所有的value
    for (value in mapOne.values){
        println("value = ${value}")
    }

    // 遍历所有的key-value
    for ((key, value) in mapOne) {
        println("${key}----${value}")
    }

//    mapOne[100] =""
    // mutableMapOf 是可变的 可以修改key所对应的value
    val mapFour = mutableMapOf(100 to "Jack")
    mapFour[100] = "John"

    val user = User(mapOf("name" to "Jack", "gender" to "male"))

    // 读取映射值
    println("${user.name} - ${user.gender}")


}

open class Outer {

    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 // public by default

    protected class Nested {
        public val e: Int = 5
    }
}

class Person {

    var age: Int = 0
        set(value) {
            field = value
        }
        get() = field
    var gender: String = "male"
        set(value) {
            field = value
        }
        get() = field
    var look: String = "handsome"
        set(value) {
            field = value
        }
        get() = field
    var voice: String = "good"
        set(value) {
            field = value
        }
        get() = field

    override fun toString(): String {
        return "[age:$age, gender:$gender, look:$look, voice:$voice]"
    }
}


class Subclass : Outer() {

    // 要覆写Outer中的成员b 则必须在前面加上 override
    // 如果覆写了一个protected 成员并且没有指明可见性，那么该覆写的可见性是protected
    override val b = 5 // b is protected

    fun sayHi() {
        // println(a) // a is not visible
        println("$b $c $d") // b c d are visible
        val nested: Nested = Nested()
        println(nested.e) // nested and e are visible
    }
}

class Unrelated(var o: Outer, var name: String) {
    fun sayHi() {
        // println(o.a) // o.a is not visible
        // println(o.b) // o.b is not visible
        println("${o.c} ${o.d}")  // o.c o.d are visible
        // Outer.Nested is not visible and Nested::e is not visible either
    }
}



class User(val map:Map<String, Any?>){
    val name:String by map
    val gender:String by map
}




































