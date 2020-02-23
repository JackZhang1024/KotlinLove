package com.luckyboy.kotlinlean.chapter03

/* 接口代理 */

class Manager:Driver, Writer{

    override fun drive() {

    }

    override fun write() {

    }

}

// 构造方法接口代理 省去了重新 drive 和 write 方法
class SeniorManager(val driver: Driver, val writer: Writer):Driver by driver, Writer by writer


class CarDriver:Driver{

    override fun drive() {
        println("正在开车")
    }
}

class PPTWriter:Writer{

    override fun write() {
      println("正在写PPT")
    }

}

interface Driver{

    fun drive()
}

interface Writer{

    fun write()
}


fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()

    val seniorManager = SeniorManager(driver, writer)
    seniorManager.drive()
    seniorManager.write()


}