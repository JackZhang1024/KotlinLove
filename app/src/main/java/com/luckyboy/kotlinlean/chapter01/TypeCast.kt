package com.luckyboy.kotlinlean.chapter01

// 类型转换灵活
fun main(args: Array<String>) {
    val parent:Parent = Child();
    if (parent is Child){
        println(parent.name); // 智能转化成Child类型
    }

    val string:String? = "Hello";
    println(string!!.length);

    val parents:Parent = Parent();

//    val child:Child? = parent as Child; // 类似与Java的强制类型转换，如果转换不成，则抛出异常
    val child:Child? = parents as? Child; // 安全的类型转换 如果不能转换, 则返回null
    println(child);


}


