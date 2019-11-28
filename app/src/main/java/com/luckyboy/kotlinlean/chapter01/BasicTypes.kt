package com.luckyboy.kotlinlean.chapter01

// kotlin 中已经不关心是否是装箱类型

// Boolean 类型
val aBoolean:Boolean = true;
val aAnotherBoolean:Boolean = false;

// NUmber 类型
val aInt:Int = 9;
val anotherInt:Int = 0xFF;
val moreInt:Int = 0b00000011;
val maxInt:Int = Int.MAX_VALUE;
val minInt:Int = Int.MIN_VALUE;
val aLong:Long = 21222222222222222;
val anotherLong:Long = 123;
val maxLong:Long = Long.MAX_VALUE;
val minLong:Long = Long.MIN_VALUE;
val aFloat:Float = 2.0f;
val anotherFloat:Float = 1E3F;
val maxFloat:Float = Float.MAX_VALUE;
val minFloat:Float = Float.MIN_VALUE;
val aDouble:Double = 3.0;
val anotherDouble:Double = 3.1425125666;
val maxDouble:Double = Double.MAX_VALUE;
val minDouble:Double = Double.MIN_VALUE;

val aShort:Short = 127;
val anotherShort:Short = 4560;
val maxShort:Short = Short.MAX_VALUE;
val minShort:Short = Short.MIN_VALUE;

val maxByte:Byte = Byte.MAX_VALUE;
val minByte:Byte = Byte.MIN_VALUE;



fun main(args: Array<String>) {
    println("Hello world");
    println(anotherInt);
    println(moreInt);

    println(maxInt);
    println(Math.pow(2.0, 31.0)-1);
    println(minInt);
    println(-Math.pow(2.0, 31.0));

    println(aLong);
    println(anotherLong);

    println(maxLong);
    println(Math.pow(2.0, 64.0)-1);
    println(minLong);
    println(-Math.pow(2.0, 64.0));

    println(aFloat);
    println(anotherFloat);

    println(maxFloat);
    println(minFloat);

    //println(0.0F/0.0F);

    println(aDouble);
    println(anotherDouble);
    println(maxDouble);
    println(minDouble);

    println(aShort);
    println(anotherShort);
    println(maxShort);
    println(minShort);

    println(maxByte);
    println(minByte);



}

