package com.luckyboy.kotlinlean.chapter04


/* 闭包操作 */

val string = "hello world"

// 在函数中调用函数 在Java中不可以的 但是在kotlin中函数作为一等公民是可以的
// 闭包就是 函数的运行环境 持有函数运行状态
fun makeFun(): () -> Unit {
    var count = 0
    // 匿名函数
    return fun() {
        println(++count)
    }
}

// 这个作用雨就是闭包 属性 方法
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return fun(): Long {
        val result = second
        second += first
        first = second - first
        return result
    }

}

// 迭代器
fun fibonaccii(): Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() {

            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }

            override fun hasNext() = true
        }
    }
}

//fun add(x:Int)=fun(y:Int)=x+y

fun add(x:Int):(Int)->Int{
    return fun(y:Int):Int{
        return x+y
    }
}


fun main(args: Array<String>) {

    // 以下操作看起来 count没有释放 每次操作都会对count有影响
    val x = makeFun()
    x()
    x()
    x()
    x()
    x()

    println("Fibonacci ")
    val y = fibonacci()
    println(y())
    println(y())
    println(y())
    println(y())
    println(y())
    println(y())

    println("Fibonacci ")
    for ( i in fibonaccii()){
         if (i > 100) break
         println(i)
    }

    //闭包就是 函数的运行环境 持有函数运行状态
    //函数中嵌套函数
    val add5 = add(5);
    println(add5(2))



}