package com.luckyboy.kotlinlean.chapter01


// 只有一个构造方法的时候使用
class Girl constructor(var name:String, var look:String, var voice:String){

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



}



