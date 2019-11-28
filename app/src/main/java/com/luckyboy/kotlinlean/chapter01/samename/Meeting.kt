package com.luckyboy.kotlinlean.chapter01.samename

import com.luckyboy.kotlinlean.chapter01.samename.beijing.CityMayor
import com.luckyboy.kotlinlean.chapter01.samename.shanghai.CityMayor as SHCityMayor // 给shanghai.CityMayor


fun main(args: Array<String>) {
    val beijingMayor:CityMayor = CityMayor("zhang");
    //val shanghaiMayor:com.luckyboy.kotlinlean.chapter01.samename.shanghai.CityMayor =
    //    com.luckyboy.kotlinlean.chapter01.samename.shanghai.CityMayor("li");
    val shanghaiMayor:SHCityMayor = SHCityMayor("li");


}