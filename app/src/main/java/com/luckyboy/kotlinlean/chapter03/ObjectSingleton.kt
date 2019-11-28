package com.luckyboy.kotlinlean.chapter03


class HardWarDriver

interface OnExternalDriverMountListener{

    fun onMount(driver: HardWarDriver);

    fun onUnMount(driver: HardWarDriver);
}


abstract class Player

// 单例的实现
object MusicPlayer:Player(), OnExternalDriverMountListener{


    val state:Int = 0;

    fun play(url:String){

    }

    fun stop(){

    }


    override fun onMount(driver: HardWarDriver) {

    }

    override fun onUnMount(driver: HardWarDriver) {

    }

}


fun main(args: Array<String>) {
    val player:MusicPlayer = MusicPlayer;
    val player1:MusicPlayer = MusicPlayer;
    println(player === player1) // true 表示是同一个对象



}