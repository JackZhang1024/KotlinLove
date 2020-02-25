package com.luckyboy.kotlinlean.chapter03

/* 非静态内部类持有外部类的状态 静态内部类不持有外部类的状态 */

// 默认是静态内部类
class Outter{

    class Inner{

        fun hello(){
            println("静态内部类 Inner ")
        }
    }

}

// 用inner来修饰非静态内部类
class Outter1{

    val a:Int = 5

    inner class Inner1{

        val a:Int = 4

        fun hello(){
            println(this@Outter1.a)
        }

        fun helloInner(){
            println(this.a)
        }
    }

}

interface OnClickListener{
    fun onClick()
}

class View{
    var onClickListener:OnClickListener ?=null
}


fun main(args: Array<String>) {
    // 非静态内部类
    val outter1:Outter1 = Outter1()
    val inner1 = outter1.Inner1();
    inner1.hello()
    inner1.helloInner()

    // 静态内部类
    val inner = Outter.Inner()
    inner.hello()

    val view = View()
    view.onClickListener = object :OnClickListener{
        override fun onClick() {

        }
    }

}

