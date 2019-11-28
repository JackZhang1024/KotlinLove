package com.luckyboy.kotlinlean.chapter01


//fun getName(): String {
//    return null;
//}

// getGender 有可能返回null,也有可能不返回null  使用方法 返回值类型后面添加?
fun getGender(): String? {
    return null;
    //return "male";
}

fun getHobby(): String? {
    //return null;
    return "swim";
}

fun main(args: Array<String>) {
    //println(getName());
    println(getGender());
    println(getGender()?.length);
    println(getHobby()?.length); // null
//    var gender = getGender()?:return; // ?: 叫做else运算符 如果为null 直接返回跳出方法 如果不为null 则继续执行
//    println(gender);

    val values:String?="HelloWorld"; // values是可null类型
    println(values!!.length); // 告诉编译器我明确知道这个不是null 可以直接使用


}