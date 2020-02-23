package com.luckyboy.kotlinlean.chapter01


// 只有一个构造方法的时候使用
class Girl(var name:String, var look:String, var voice:String){

}

class Boy(var name:String, var look:String, var voice:String){

    init {
        println("初始化了一个Boy, 信息是: 姓名：$name, 长相：$look, 声音：$voice");
    }
}

class Teacher(var name:String, var look:String, var voice:String)

open class Human(var name: String, var look: String, var voice: String){
    init {
        println("初始化了一个${this.javaClass.simpleName}, 信息是: 姓名：$name, 长相：$look, 声音：$voice");
    }
}

class Person(name:String, age:Int){ // 主构造器

    private var gender:Int = 0
//        set(value){
//            field = value
//        }
//
//        get() {
//            return field
//        }

    constructor(name:String, age:Int, gender:Int):this(name, age){ // 次构造器
        this.gender = gender
        println("次构造执行 $gender")
    }

    init { // init 初始化化代码块
        println("init代码块 $name $age")
    }

}

class Cat(name:String){

    init {
       println("$name")
    }



}

// 继承写法 Student 继承Human 将 name, look, voice 传递给Human的构造方法
class Student(name: String, look: String, voice: String):Human(name, look, voice)

fun main(args: Array<String>) {
    val girl:Girl=Girl("lucy", "beautify", "nice");
    println(girl.look);

    val boy:Boy = Boy("Jack", "handsome", "nice");
    println(boy.look);

    val teacher:Teacher = Teacher("Smith", "handsome", "good");
    println(teacher.name);

    val student:Student = Student("bobby", "cute", "nice");
    println(student.name);

    println(student is Human);

    val person:Person = Person("Jack", 18, 1)
//    person.gender = 3
//    println(person.gender)

    val cat = Cat("miaomiao")




}



