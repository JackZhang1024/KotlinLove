package com.luckyboy.kotlinlean.chapter02

val strings:Array<String> = arrayOf("1", "2", "3");

/*
* lambda表达式
* 匿名函数
* 写法: {[参数列表]->[函数体,最后一行是函数的返回值 ]}
* 举例：
* val sum = {a:Int, b:Int-> a+b }
*
* ()->Unit -无参 返回值是Unit
*
* (Int)->Int - 传入整形 返回值是整形
*
* (String, (String)->String)->Boolean - 传入一个字符串 Lambda 表达式 返回boolean
*
* 用()进行调用
* 等价于 invoke()
* 举例：
* val sum = {a:Int, b:Int-> a+b}
* sum(2, 3)
* sum.invoke(2,3)
*
* 函数参数调用时最后一个Lambda可以移出去
* 函数参数只有一个Lambda, 调用时小括号可以省略
* Lambda 只有一个参数可以默认为 it
*
* 入参, 返回值于形参一致的函数可以用函数引用的方式作为实参传入 函数引用！！！！
*
* */

// Unit 相当于 Java中的 void
fun main(args: Array<String>): Unit { // (Array<String>)->Unit
    //println("Hello ${args[0]}");
    println(sum1(1, 2));
    println(sum2(1, 3));
    println(sum3(1, 3));
    println(sum4(1, 3));
    println(sum3.invoke(1, 3)); // 运算符重载
    println(sum4.invoke(1, 3)); // 运算符重载
    printHello.invoke();
    strings.forEach({
        println(it);
    })
    strings.forEach({
            println(it)
        }
    );
    println("The Start....");
    strings.forEach ForEach@{
        if (it =="2") return@ForEach
        println(it);
    }
    // 跳出循环
    println("The End....");
    strings.forEach(::println) // :: 表示函数名  forEach需要的参数和println的类型一致 则直接传入括号内
    println(sum4);
    println(int2Long);
    //println(::printHello);


}

fun sum1(arg:Int, arg2:Int): Int {
    return arg+arg2;
}


fun sum2(arg:Int, arg2:Int)=arg+arg2

// lambda 表达式
val sum3 = {arg:Int, arg2:Int-> arg + arg2}

val sum4 = {arg:Int, arg2:Int->
    println("$arg+$arg2 =${arg+arg2}");
    arg + arg2
}

// （）->Unit
val printHello = {
    println("hello");
}

// (Int)-> Long
val int2Long = fun(x:Int):Long{
    return x.toLong();
}









