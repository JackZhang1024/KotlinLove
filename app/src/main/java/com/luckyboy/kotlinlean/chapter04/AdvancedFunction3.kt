package com.luckyboy.kotlinlean.chapter04

import java.io.BufferedReader
import java.io.FileReader

data class Person(val name: Int, val age: Int) {

    fun work() {
        println("$name is working")
    }
}


fun findPerson(): Person? {
    return null;
}


fun main(args: Array<String>) {
//    val person = findPerson()
//
//    println(person?.name)
//    println(person?.age)
//

//    findPerson()?.let { person ->
//        person.work()
//        println(person.name)
//        println(person.age)
//    }

//    val br = BufferedReader(FileReader("hello.txt"))
//    // 在br的作用域内 都可以使用BufferedReader的成员方法
//    with(br){
//        var line:String?
//        while(true){
//            line = readLine()?:break
//            println(line)
//        }
//        close()
//    }

    // 一次性全部读取出文件中所有行的内容
    println(BufferedReader(FileReader("hello.txt")).readLines())


    BufferedReader(FileReader("hello.txt")).use {
        var line: String?
        while (true) {
            line = readLine() ?: break
            println(line)
        }
    }


}



