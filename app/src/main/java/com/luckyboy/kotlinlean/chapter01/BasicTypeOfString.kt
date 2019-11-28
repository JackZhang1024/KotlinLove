package com.luckyboy.kotlinlean.chapter01

val string: String = "HelloWorld";
val fromChars: String = String(charArrayOf('H','e','l','l','o','W','o','r','l','d'));

// kotlin 中 == 等同于Java 中的equals
// === 才能判断是否是同一个对象

fun main(args: Array<String>) {
    println(string == fromChars);
    println(string === fromChars);

    println("接下来我们输出"+ string);

    val arg1:Int = 0;
    val arg2:Int = 1;
    println(""+ arg1+" + "+arg2+" = "+(arg1+arg2));

    // 字符串模版
    println("$arg1+$arg2=${arg1+arg2}");

    // Hello "Trump"
    val sayHello:String = "Hello \"Trump\"";
    println(sayHello);

    // salary 美元符号
    val salary:Int = 100;
    println("$$salary");
    println("\$salary");

    val rawString:String = """ \t\n $salary $ salary""";
    println(rawString);
    println(rawString.length);

}