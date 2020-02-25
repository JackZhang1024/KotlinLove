package com.luckyboy.kotlinlean.chapter01

open abstract class Humans(var name: String, var look: String) {

    fun showMe() {
        println("I'am ${name} ,I look like ${look}")
    }

    abstract fun loadHobby(): String?
}

class Male(name: String, look: String) : Humans(name, look) {

    private lateinit var mHobby: String

    constructor(name: String, look: String, hobby: String) : this(name, look) {
        this.mHobby = hobby
    }

    override fun loadHobby(): String? {
        return "I like $mHobby"
    }
}


class Female(name: String, look: String) : Humans(name, look) {

    private lateinit var mHobby: String

    constructor(name: String, look: String, hobby: String) : this(name, look) {
        this.mHobby = hobby
    }

    override fun loadHobby(): String? {
        return "I like $mHobby"
    }

}


class Dog {
    lateinit var name: String
    val color: String by lazy {
        "yellow"
    }

    fun setDogName(name: String) {
        this.name = name
    }
}


interface ISwim {
    fun swim()
}

class Fish : ISwim {
    override fun swim() {
        println("我是鱼 我能游泳")
    }
}

class Penguin : ISwim {
    override fun swim() {
        println("我是企鹅 我能游泳")
    }
}


inline fun calculatePrint(funN: (Int, Int) -> Int) {
    println("${funN(10, 5)}")
}


fun kLog(tag: String, value: String) {
    println("$tag : $value")
}


class KLog {

    fun kLog(tag: String, value: String) {
        println("$tag : $value")
    }

}


fun main(args: Array<String>) {
    val male = Male("Jack", "handsome", "play football")
    male.showMe()
    println(male.loadHobby())
    val female = Female("Lily", "beautify", "dance")
    female.showMe()
    println(female.loadHobby())

    val names = arrayOf("Jack", "Rose", "lily")
    for (name in names) {
        println(name)
    }

    calculatePrint { a, b -> a + b }
    calculatePrint { a, b -> a - b }

    val logFunc = ::kLog
    logFunc("KLOG", "Hello World")

    //
    val kLogFunc = KLog::kLog
    val kLog = KLog()
    kLogFunc(kLog, "KLOG", "Hello China")
    //kLogFunc.call(kLog, "KLOG", "Hello China")

    val iName = Int::class.java
    println(iName.simpleName)

}


