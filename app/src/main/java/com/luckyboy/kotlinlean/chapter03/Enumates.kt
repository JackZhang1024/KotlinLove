package com.luckyboy.kotlinlean.chapter03

// 枚举
enum class LogLevel(val id:Int){

    // kotlin 中强制写分号的地方 枚举
    VERBOSE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), ASSERT(5);

    fun getTag():String{
        return "$id, $name"
    }

    override fun toString(): String {
        return "$name, $ordinal"
    }
}


fun main(args: Array<String>) {
    println(LogLevel.DEBUG.getTag())
    println(LogLevel.DEBUG.ordinal)

    LogLevel.values().map(::println)

    println(LogLevel.valueOf("error".toUpperCase()))


}