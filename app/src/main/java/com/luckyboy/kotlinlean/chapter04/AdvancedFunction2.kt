package com.luckyboy.kotlinlean.chapter04

import java.lang.StringBuilder


fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5 )

//    val newlist = ArrayList<Int>()
//
//    list.forEach{
//        val newElement = it*2+3
//        newlist.add(newElement)
//    }
//
//    newlist.forEach(::println)

    val newlist = list.map {
        it*2+3
    }


    val newlist2 = list.map(Int::toDouble)

    newlist2.forEach(::println)

    // map 使用来做映射操作
    list.map(::println)

    val list3 = listOf(1..20, 2..5, 10..200)

    // flatMap 打平 把集合的集合打平
    // val flatList = list3.flatMap { it }

//    val flatList = list3.flatMap{intRange: IntRange ->
//        intRange.map {
//            "No $it"
//        }
//    }


//    val flatList = list3.flatMap { it }
//    flatList.forEach(::println)
//    val accResult = flatList.reduce { acc, i -> acc+i}  // 求和操作
//    println(accResult)

//    (0..6).map (::factorial).forEach(::println)
//    (0..6).map (::factorial).reduce{acc, i->acc+i}


    (0..6).map(::factorial).fold(5){acc, i->acc+i}

    // 拼接字符串
    println((0..6).map(::factorial).fold(StringBuilder()){ acc, i->acc.append(i).append(",")})


    println((0..6).map(::factorial).foldRight(StringBuilder()){ i, acc->acc.append(i).append(",")})

    println((0..6).joinToString())

    // 筛选出来结果是奇数  偶数不在集合中了
    println((0..6).map(::factorial).filter{ println(it); it%2==1});

    // 筛选出在奇数位置上的数据
    println((0..6).map(::factorial).filterIndexed { index, i -> index%2==1});

    // takeWhile 遇到不符合的就结束取数据
    println((0..6).map(::factorial).takeWhile { it%2==1});


    arrayOf(1,2,3).map { i:Int ->i*10}.forEach(::println)

}

fun factorial(n:Int):Int{
    if (n==0) return 1
    return (1..n).reduce { acc, i ->  acc*i} // 1..n 连续相乘操作

}
