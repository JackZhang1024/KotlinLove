package com.luckyboy.kotlinlean.chapter03

class House

class Flower

class CountryYard{

    val house:House = House()

    private val flower:Flower = Flower()

}

// internal 模块内可见
// protected 子类可见
// 不写的情况下是public的
class ForbiddenCity{

    internal val houses  = arrayOf(House(), House())

    val flowers = arrayOf(Flower(),Flower())

}

fun main(args: Array<String>) {

    val countryYard = CountryYard()
    countryYard.house
    var forbiddenCity = ForbiddenCity()
}

