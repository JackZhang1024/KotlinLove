package com.luckyboy.kotlinlean.chapter04

import java.io.File


/* 字符统计 */
fun main(args: Array<String>) {
    val map = HashMap<Char, Int>()

//    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace).forEach{
//        val count = map[it]
//        if (count == null) map[it] = 1
//        else map[it] = count+1
//    }
//
//    map.forEach(::println)



    //
    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace).groupBy {
        it // 按照it的元素来分组
    }.map {
        it.key to it.value.size // 统计字符个数 类似于这种 (D, 3)
    }.forEach(::println)


}