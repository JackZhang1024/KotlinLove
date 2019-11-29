package com.luckyboy.kotlinlean.chapter04


// 高阶函数
// 传入或者返回函数的函数
// 函数引用 ::println
// 带有Receiver的引用 pdfPrinter::println

fun main(args: Array<String>) {
    args.forEach(::println)
    // 具名引用到具体的某一个函数 叫具名函数
    // 1. 包机函数
    val hello = Hello::world // 类名加::方法名 就可以限定某个方法了
    // 2. 类名引用
    args.filter(String::isNotEmpty)

    // 3. 调用者引用方式
    val pdfPrinter = PDFPrinter()
    args.forEach(pdfPrinter::println)

}

class PDFPrinter{

    fun println(any: Any){
        kotlin.io.println(any)
    }

}


class Hello{

    fun world(){
        println("Hello world")
    }

}