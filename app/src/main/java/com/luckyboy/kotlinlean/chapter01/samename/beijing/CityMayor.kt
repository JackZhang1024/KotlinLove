package com.luckyboy.kotlinlean.chapter01.samename.beijing

class CityMayor(var name: String){
    init {
        println("beijing mayor");
    }

    override fun toString(): String {
        return "$name 市长"
    }


}
