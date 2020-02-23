package com.luckyboy.kotlinlean.chapter01

open abstract class Humans(var name: String, var look: String) {

    fun showMe(){
        println("I'am ${name} ,I look like ${look}")
    }

    abstract fun loadHobby():String?
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


class Female (name: String, look: String) : Humans(name, look) {

    private lateinit var mHobby: String

    constructor(name: String, look: String, hobby: String) : this(name, look) {
        this.mHobby = hobby
    }

    override fun loadHobby(): String? {
        return "I like $mHobby"
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
    for (name in names){
        println(name)
    }
}
