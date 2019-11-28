package com.luckyboy.kotlinlean.chapter02

class Complex(var real:Double, var imaginary:Double){


    operator fun plus(other:Complex):Complex{
        return Complex(real+other.real, imaginary+other.imaginary)
    }

    operator fun plus(other:Int):Complex{
        return Complex(real+other, imaginary);
    }

    operator fun plus(other:Any):Int{
        return real.toInt();
    }

    override fun toString(): String {
        return "$real+${imaginary}i"
    }

    operator fun invoke():Double{
        return Math.hypot(real, imaginary);
    }

}


// 中缀表达式 只有一个参数 且用infix修饰方法
class Book{
    infix fun on(any: Any):Boolean{
        return false;
    }
}

class Desk

fun main(args: Array<String>) {

    val c1 = Complex(3.0, 4.0);
    val c2 = Complex(2.0, 7.5);
    println(c1+c2);
    println(c1+10);
    println(c1+"hello");
    println(c1());

    if (Book() on Desk()){ // DSL

    }


}

