package com.luckyboy.kotlinlean.chapter02


class Girl(var character:String, var look:String, var voice:String){

    fun sing(songName:String){
        // 唱歌的具体实现
        println("正在唱歌 $songName");
    }

    fun dance(danceName:String){
        // 跳舞的具体实现
        println("正在跳舞 $danceName");
    }

}

fun main(args: Array<String>) {

    val girl:Girl = Girl("nice", "beautify", "good");
    girl.sing("molihua");
    girl.dance("tianehu");


}