package com.luckyboy.kotlinlean.chapter03;

public class StaticJava {

    public static void main(String[] args) {
        Latitude latitude0 = Latitude.Companion.ofDouble(3.0);
        Latitude latitude1 = Latitude.ofDouble(4.0);

        // Java中使用Latitude 中的TAG
        System.out.println(Latitude.TAG);


    }
}
