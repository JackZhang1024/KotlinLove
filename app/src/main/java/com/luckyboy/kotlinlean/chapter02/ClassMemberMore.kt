package com.luckyboy.kotlinlean.chapter02

// kotlin 中的set get 方法
// kotlin 中默认的访问控制是public
class Boy{

    var age = 0
       get() {
           println("someone tries to get age");
           return field;
       }
       set(value) {
           println("someont tries to set age");
           field = value;
       }

    val weight =0
    get() {
      return field;
    }

    //set(value) {}  // val 不能用setter
}

// 延迟初始化  lateinit 只能用于var
class Master{
    var age = 0
    lateinit var gender:String
    lateinit var kongfu:String
    //lateinit val height:String;
    val height:String by lazy{
        println("init height")
        "182"
    }

}


fun main(args: Array<String>) {
    val master:Master=Master();
    println(master.height);
    //println(master.gender);
    master.kongfu = "如来神掌";
    println(master.kongfu);


}