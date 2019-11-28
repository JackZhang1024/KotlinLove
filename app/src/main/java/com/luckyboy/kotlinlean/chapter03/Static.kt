package com.luckyboy.kotlinlean.chapter03


// 包级函数 包级变量
fun main(args: Array<String>) {
    val a = minOf(10, 3);

    val latitude  = Latitude.ofDouble(3.0)
    val latitude2 = Latitude.ofLatitude(latitude)

    println(Latitude.TAG)


}

class Latitude private constructor(val value:Double){

    // companion object 伴生对象
    companion object{

        // @JvmStatic 可以在Java中使kotlin使用像Java中一样
        @JvmStatic
        fun ofDouble(double: Double): Latitude{
            return Latitude(double)
        }

        fun ofLatitude(latitude: Latitude): Latitude{
            return Latitude(latitude.value)
        }

        @JvmField
        val TAG:String = "latitude"
    }



}