package com.luckyboy.kotlinlean.chapter01

import com.luckyboy.kotlinlean.chapter01.samename.beijing.CityMayor

val arrayOfInt:IntArray = intArrayOf(1, 3, 5, 7);
val arrayOfChar:CharArray = charArrayOf('a', 'b', 'c');
val arrayOfString:Array<String> = arrayOf("我", "是", "Jack");
val arrayOfMayor:Array<CityMayor> = arrayOf(CityMayor("王"), CityMayor("李"));

fun main(args: Array<String>) {

    println(arrayOfInt.size);
    for (int in arrayOfInt){
         println(int);
    }

    println(arrayOfMayor[1]);
    println(arrayOfMayor[1].name);

    arrayOfMayor[1] = CityMayor("赵");
    println(arrayOfMayor[1]);

    println(arrayOfChar.joinToString()); // a, b, c
    println(arrayOfChar.joinToString("")); // abc
    println(arrayOfChar.joinToString("|")); // a|b|c

    println(arrayOfInt.slice(1..2));

    println(String(arrayOfChar));

    println(CityMayor::class.java.simpleName);
    println(CityMayor::class.java.name);
    println(CityMayor::class.java.name.slice(0 until 3)); // [0, 3)  com



}