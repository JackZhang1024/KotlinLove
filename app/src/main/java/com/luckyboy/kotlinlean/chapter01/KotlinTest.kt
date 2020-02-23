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

    fun setDogName(name: String){
        this.name = name
    }
}


interface ISwim {
    fun swim()
}

class Fish:ISwim {
    override fun swim() {
       println("我是鱼 我能游泳")
    }
}

class Penguin :ISwim {
    override fun swim() {
       println("我是企鹅 我能游泳")
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



}


