package com.luckyboy.kotlinlean.chapter03

abstract class AA {

    open fun x(): Int = 10;
}

interface BB {
    fun x(): Int = 1
}

interface CC {
    fun x(): Int = 0
}


class DD(var y: Int = 0) : AA(), BB, CC {

    override fun x(): Int {
        println("call x() int DD")
        if (y > 0) {
            return y;
        } else if (y > -100) {
            return super<BB>.x()
        } else if (y > -200) {
            return super<CC>.x()
        } else {
            return super<AA>.x()
        }
    }

}


fun main(args: Array<String>) {
    println(DD(3).x())
    println(DD(-40).x())
    println(DD(-120).x())
    println(DD(-300).x())

}