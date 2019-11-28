package com.luckyboy.kotlinlean.chapter02

class Player{

    enum class State{
        IDLE, BUFFERING, PLAYING, PAUSED
    }

    private var state = State.IDLE

    fun pause(){
        when(state){
            State.BUFFERING, State.PLAYING->doPause()
            else->{
                println("如果不是BUFFERING, PLAYING 则执行else")
            }
        }
    }

    fun resume(){
        when(state){
            State.PAUSED->doResume()
        }
    }

    private fun doResume() {

    }

    private fun doPause() {

    }



}

fun main(args: Array<String>) {


}