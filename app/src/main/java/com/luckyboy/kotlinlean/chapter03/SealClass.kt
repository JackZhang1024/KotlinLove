package com.luckyboy.kotlinlean.chapter03

/* 密封类是子类可数的类 枚举是实例可数 */
/* sealed class 只能在和父类在同一个文件或者在父类中 */
sealed class PlayerCmd{

    class Play(val url:String, val position:Long = 0):PlayerCmd()

    class Seek(val position:Long = 0):PlayerCmd()

    // 没有参数可以用 object 使用
    object Pause:PlayerCmd()

    object Resume:PlayerCmd()

    object Stop:PlayerCmd()


}