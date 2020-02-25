

# Kotlin基础

1. var 和 val 

   var 是变量，是可以在初始化之后，再次进行赋值操作的，val 是不可变量，初始化或者赋值之后，再次进行赋值会报错

2. Kotlin中常见的基本数据类型

   ```kotlin
   var aInt: Int = 1
   var aFloat:Float = 2.0F
   var aLong:Long = 3000L
   var aDouble:Double = 3.2143
   var aShort:Short = 123
   var aBbyte:Byte = Byte.MAX_VALUE
   var aBoolean:Boolean = true
   ```

3. 数组和集合

   * 基本类型数组

   ```kotlin
   // 整数数组
   var arrayOfInt:IntArray = intArrayOf(1,3,5,7)
   // 字符数组
   var arrayOfChar:CharArray = charArrayOf('a','b','c')
   // 字符串数组
   var arrayOfString:Array<String> = arrayOf("hello","world")
   ```

   - 对象类型数组

   ```kotlin
   class CityMayor(var name:String){
       init{
          println("init cityMayor")
       }
   }
   var arrayOfMayor:Array<CityMayor> = arrayOf(CityMayor("北京"))
   ```

   - 数组的常见操作

   ```kotlin
   // 数组的连接
   var arrayOfChar:CharArray = charArrayOf('a', 'b','c')
   println(arrayOfChar.joinToString()) // a,b,c
   println(arrayOfChar.joinToString("")) // abc
   println(arrayOfChar.joinToString("|")) // a|b|c
   
   // Returns a list containing elements at indices in the specified [indices] range.
   // 返回一个在指定下标范围内的列表
   var arrayOfInt:IntArray = intArrayOf(1, 3, 5, 7)
   println(arrayOfInt.slice(1..2)) // [3,5]
   println(arrayofChar.slice(0,1)) // [a]
   
   // 截取字符串
   println("hello".slice(0..1)) // he
   println("hello".slice(0 unitl 1)) // h 
   ```

4. 类和构造方法以及初始化

   - kotlin 类初步认识

   ```kotlin
   class Person {
     
   }
   ```

   - kotlin 带有主构造器和次构造器的类

   ```kotlin
   class Person(name:String, age:Int) { // 主构造器
      private var gender:Int = 0
      constructor(name:String, age:Int, gender:Int):this(name, age){ // 次构造器
         this.gender = gender
         println("次构造器执行 $gender")
      }
     
      init { // init 初始化化代码块
         println("init代码块 $name $age")
      }
   }
   
   fun main(args: Array<String>){
      val person = Person("Jack", 18, 1)
      // person.gender 这句执行不了 
   }
   ```

   看下执行main方法后的结构

   ```java 
   init代码块 Jack 18
   次构造器执行 1
   ```

   在创建类的过程中有几个细节需要注意：

   - 在主构造器上 我们可以在变量名前面加上 var 或 val , 也可以不加 但是有区别：加上之后 我们可以直接在类的外部使用`person.name`直接获取到对象的`name`对应的value 如果不加 我们则不能直接获取到对应的属性值    个人认为一般最好加上var 方便时候用
   - 在次构造器上不能加 var 或者 val 
   - 在创建对象的过程中，init代码块先于次构造器先执行
   - 不确定init代码块是比主构造器先执行？？？

   - 关于对象的属性和方法调用

     1. 如果在主构造器上上使用 var 或者 val 声明属性，则我们可以直接使用类似 `person.name`的方式获取属性值 ，如果没有在主构造器上使用var 或者 val 来声明属性，则我们不能获取到对应的属性值

     ```kotlin
     class Cat(var name:String, var age:Int){
     
     }
     
     fun main(args:Array<String>){
        var cat:Cat = Cat("miaomiao", 3)
        println(cat.name) // miao
        println(cat.age)  // 3
        cat.name = "lily"
        println(cat.name) // lily
     }
     ```

     2. 对于在类中声明的成员变量，我们使用 set 和 get 方法 获取和设置属性

     ```kotlin
     class Cat(var name:String, var age:Int){
         var color:String? = null
             set(value) {
                 field = value
             }
             get() {
                 return "体色 $field"
             }
         var gender:Int = 0
             set(value) {
                 field = value
             }
             get() {
                 return field
             }
     }
     
     var cat = Cat("miao", 2)
     cat.color = "黄色"
     cat.gender= 1
     println(cat.color) // 体色 黄色
     println(cat.gender)// 1
     ```

   - 类的继承

     ```kotlin	
     open abstract class Humans(var name: String, var look: String) {
         fun showMe(){
             println("I'am ${name} ,I look like ${look}")
         }
         abstract fun loadHobby():String?
     }
     
     class Male(name: String, look: String) : Humans(name, look) {
         private lateinit var mHobby: String
         constructor(name: String, look: String, hobby: String) : this(name, look) {
             this.mHobby = hobby
         }
         override fun loadHobby(): String? {
             return "I like $mHobby"
         }
     }
     
     class Female (name: String, look: String) : Humans(name, look) {
         private lateinit var mHobby: String
         constructor(name: String, look: String, hobby: String) : this(name, look) {
             this.mHobby = hobby
         }
         override fun loadHobby(): String? {
             return "I like $mHobby"
         }
     }
     
     val male = Male("Jack", "handsome", "play football")
     male.showMe() // I'am Jack ,I look like handsome
     println(male.loadHobby()) // I like play football
     val female = Female("Lily", "beautify", "dance")
     female.showMe()  // I'am Lily ,I look like beautify
     println(female.loadHobby()) // I like dance
     ```

5. 常见的Kotlin符号 （？ ?.   ?:  !!  as is ）

   - 关于问号？表示可为空

     正常情况下，var 声明的变量不能为`null`,且必须初始化，如果想设置为`null`, 则需要在变量类型后面加个问号`?`, 表示可为空

   ```kotlin
   var name:String? = null
   println(name)
   // null  
   
   var name:String
   println(name)
   // error: property must be initialized or be abstract
   // var name:String
   // ^
   // error: variable 'name' must be initialized
   // println(name)
   //        ^
   
   var name:String = null
   println(name)
   //error: null can not be a value of a non-null type String
   //var name:String = null
   ```

   - 关于 ?. 表示不为空 则就使用该属性或者方法 否则就返回null 

   ```kotlin
   class Cat(var name:String){
       fun miao(){
           println("$name say miao~~~")
       }
   }
   
   var cat:Cat?= null
   println(cat?.miao()) // null
   println(cat?.name) // null
   ```

   - 关于 ?: 的使用 A?:B 如果A不为空，则返回自身，如果为空 ，返回B

   ```kotlin
   var name:String? = null
   var result = name?:"Jack"
   println(result)
   // Jack
   var nickname:String = "doudou"
   var result_nick = nickname?:"rose"
   println(result_nick)
   // doudou
   ```

   - 关于 !!的使用 

   ```kotlin 
   val name:String? = null
   //println(name.length) // 这中写法在kotlin中是不允许的 name要么为null要么在在属性length前面加!!.
   println(name!!.length)
   ```

   ![non-null](./总结/images/non-null.png)

   - 关于 as is 的使用 涉及到类型转换问题 

     ```kotlin 
     open class Parent(var name:String){
        open fun sayHi(){
            println("parent $name say hello")
         }
     }
     class Child(name:String, age:Int):Parent(name) {
         override fun sayHi() {
             println("child $name say hello")
         }
     }
     
     val childOne:Parent = Child("Bruce Li", 12)
     if (childOne is Parent){
     }
     if (childOne is Child){
         childOne.sayHi()
     }
     val childTwo:Parent = Parent("Bruce Li")
     if (childTwo is Parent){
         childTwo.sayHi()
     }
     if (childTwo is Child){
         childTwo.sayHi()
     }
     val childThree:Parent = Child("Bruce John", 10)
     val childTFour:Child = childThree as Child
     childTFour.sayHi()
     // Exception in thread "main" java.lang.ClassCastException: com.luckyboy.kotlinlean.Parent cannot be cast to com.luckyboy.kotlinlean.Child
     //    val childFive:Child = childTwo as Child // 不安全的类型转换
     val childFive:Child? = childTwo as? Child // 安全的类型转换
     childFive?.sayHi() // childFive为null 就不执行了 sayHi方法
     ```

     

6. 循环结构 for  和 判断结构  if  when

   循环结构 for 

   - 第一种for 循环

   ```kotlin
   val names = arrayOf("Jack", "Rose", "lily")
       for (name in names){
           println(name)
   }
   // Jack Rose lily
   ```

   - 第二中for循环

   ```kotlin
   var names:Array<String> = arrayOf("Jack", "Rose", "Lily")
   for (i in names.indices){
        println("index is $i and value ${names[i]}")
   }
   //index is 0 and value Jack index is 1 and value Rose index is 2 and value Lily
   ```

   - 第三种 for 循环 

   ```kotlin 
   var names:Array<String> = arrayOf("Jack", "Rose", "Lily")
   names.forEach { 
       println(it)
   }
   // Jack Rose lily
   ```

   - 第四种for 循环

   ```kotlin 
   var names:Array<String> = arrayOf("Jack", "Rose", "Lily")
   names.forEachIndexed { index, s -> 
       println("index ${index} value ${s} ")
   }
   //index 0 value Jack index 1 value Rose index 2 value Lily
   ```

   判断结构 if else 

   -  第一种情况 条件分支语句只有一行

   ```kotlin 
   var a = 10
   var b = 12
   var result = if (a>b) "你猜错了" else  "你猜对了"
   println(result) // 你猜对了
   ```

   - 第二种情况 条件分支语句有多句

   ```kotlin 
   var a = 10 
   var b = 200
   var result = if (a>b){
        println("你死定了")
       "你猜错了"  
   } else{
       println("你好棒啊")
       "你猜对了"  
   }
   println(result)
   // 你好棒啊你猜对了
   ```

   When 语句

   - when语句第一种使用方法  when带参数

   ```kotlin 
   var score = 67
   when (score) {
       in 90..100 -> println("成绩优秀")
       in 80..89 -> println("成绩优良")
       in 60..79 -> println("成绩及格")
       else -> println("成绩不及格")
   }
   // 成绩及格
   ```

   - when第二种使用方法 when不带参数 但是有返回值

   ```kotlin 
   var score = 70
   var comment = when {
       score>=90 -> "成绩优秀"
       score>=80 -> "成绩优良"
       score>=60 -> "成绩及格"
       else -> "成绩不及格"
   }
   println(comment)
   // 成绩及格
   ```

   

7. lateinit 和 by lazy 

   Lateinit 只能用于var   by lazy 只能用于 val 

   ```kotlin 
   class Dog {
       lateinit var name: String
       val color: String by lazy {
           "yellow"
       }
       fun setDogName(name: String){
           this.name = name
       }
   }
   
   var dog = Dog()
   dog.setDogName("dahuang")
   println(dog.color)//yellow
   println(dog.name) //dahuang
   ```

8. 接口相关

   -  kotlin 接口

   ```kotlin
   interface ISwim {
       fun swim()
   }
   
   class Fish:ISwim {
       override fun swim() {
           println("我是鱼 我能游泳")
       }
   }
   
   class Penguin :ISwim {
       override fun swim() {
           println("我是企鹅 我能游泳")
       }
   }
   
   var fish = Fish()
   fish.swim() // 我是鱼 我能游泳
   var penguin = Penguin()
   penguin.swim() //我是企鹅 我能游泳
   ```

   - kotlin 构造方法接口代理  

     构造方法接口代理的意思就是说本来要实现的接口方法被主构造方法中的参数进行了接管，交给它们来进行接口方法的实现

   ```kotlin 
   interface Driver {
       fun drive()
   }
   interface Writer {
       fun write()
   }
   class PPTWriter:Writer {
       override fun write() {
           println("正在写PPT")
       }
   }
   class CarDriver:Driver {
       override fun drive() {
           println("正在开车")
       }
   }
   class SeniorManager(var driver:Driver, var writer:Writer):Driver by driver,Writer by writer{
     
   }
   
   var driver = CarDriver()
   var writer = PPTWriter()
   var seniorManager = SeniorManager(driver, writer)
   seniorManager.drive() // 正在开车
   seniorManager.write() // 正在写PPT
   ```

   - kotlin 属性代理

     一旦通过by来声明一个变量 实际就是一个傀儡 真正的实现是在代理的get方法中实现

   ```kotlin 
   /* 成员变量代理 */
   class Delegates {
       val hello by lazy {
           "hello wolrd"
       }
       val hello2 by X()
       var hello3 by X()
   }
   // 代理对象需要实现set和get方法
   class X {
        private var value:String?=null
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            println("getValue: $thisRef->${property.name} ")
            return value ?: ""
        }
       operator fun setValue(thisRef: Any?, property: KProperty<*>, value:String) {
           println("setValue: $thisRef->${property.name}=$value")
           this.value = value
       }
   }
    
   val delegates = Delegates() 
   println(delegates.hello) // hello wolrd
   println(delegates.hello2)// getValue: Delegates@41629346->hello2 
   println(delegates.hello3)// getValue: Delegates@41629346->hello3 
   delegates.hello3 = "hello world value3" // setValue: Delegates@41629346->hello3=hello world value3
   println(delegates.hello3) // getValue: Delegates@41629346->hello3  // hello world value3
   
   ```

9. 枚举

   ```kotlin 
   enum class SEASON{
       SPRING,
       SUMMER,
       AUTUMN,
       WINTER
   }
   
   for (item in SEASON.values()){
       println(item.name)
   }
   // SPRING SUMMER AUTUMN WINTER
   ```

10. 方法扩展

    下面的例子就是给已有的类添加一些新的方法来实现某些功能  比如给字符串重复指定次数拼成字符串

    ```kotlin 
    fun String.multiply(int:Int):String{
        val stringBuilder = StringBuilder()
        for (i in 0 until int){
            stringBuilder.append(this);
        }
        return stringBuilder.toString()
    }
    
    val result = "abc".multiply(3)
    println(result)  // abcabcabc
    ```

11. 单例的实现 kotlin中的单例是直接用object 来表示的 注意：单例是没有构造方法的

    ```kotlin
    object Person {
        fun sayHi(){
            println("say Hi")
        }
    }
    
    val personOne:Person = Person
    val personTwo:Person = Person
    println(personOne === personTwo) // true
    ```

12. 密封类Sealed Class 密封类是子类可数的类 枚举是实例可数 

    sealed class 只能在和父类在同一个文件或者在父类中 

    如果密封类没有参数 可以使用 object   

    ```kotlin 
    sealed class PlayerCmd {
        
        class Play(var url:String, val position:Long = 0):PlayerCmd()
        
        class Seek(val position:Long = 0)：PlayerCmd()
        
        object Pause:PlayerCmd()
        
        object Stop:PlayerCmd()
    }
    ```

13. 伴生对象 companion 

    companion 可以使类像Java中那样拥有调用静态方法的操作

    ```kotlin 
    class Latitude private constructor (val value:Double){
        // companion object 伴生对象
        companion object {
            // @JvmStatic 可以在Java中使Kotlin使用像Java在Java中一样
            @JvmStatic
            fun ofDouble(double:Double):Latitude {
                return Latitude(double)
            }
            
            fun ofLatitude(latitude:Latitude):Latitude {
                return Latitude(latitude.value)
            }
            
            @JvmField
            val TAG:String = "latitude"
        }
    }
    
    val latitude:Latitude = Latitude.ofDouble(3.0)
    val latitudeTwo:Latitude = Latitude.ofLatitude(latitude)
    println(Latitude.TAG)
    
    // 在Java中使用
    public static void main(String[] args){
       Latitude latitude0 = Latitude.Companion.ofDouble(3.0);
       Latitude latitude1 = Latitude.ofDouble(4.0);
       // Java中使用Latitude中的TAG
       System.out.println(Latitude.TAG);
    }
    
    ```

14. @JvmField 和 @JvmStatic  上面的已经解释过了

15. internal 关键字是什么意思

    intenal 和 public private protected 一样  都是可见性关键字 ，internal 的意思就是说同一模块可见，同一模块的意思官方解释如下：

    模块在 Kotlin 中就是一系列的 Kotlin 文件编译在一起：
    — an IntelliJ IDEA module;
    — a Maven or Gradle project;
    — a set of files compiled with one invocation of the Ant task.

    ```kotlin 
    open class Outer {
        private val a = 1
        protected open val b = 2
        internal val c = 3
        val d = 4 // public by default
        protected class Nested {
            public val e: Int = 5
        }
    }
    class Subclass : Outer() {
        // 要覆写Outer中的成员b 则必须在前面加上 override
        // 如果覆写了一个protected 成员并且没有指明可见性，那么该覆写的可见性是protected
        override val b = 5 // b is protected
        fun sayHi() {
            // println(a) // a is not visible
            println("$b $c $d") // b c d are visible
            val nested: Nested = Nested()
            println(nested.e) // nested and e are visible
        }
    }
    class Unrelated(var o: Outer, var name: String) {
        fun sayHi() {
            // println(o.a) // o.a is not visible
            // println(o.b) // o.b is not visible
            println("${o.c} ${o.d}")  // o.c o.d are visible
            // Outer.Nested is not visible and Nested::e is not visible either
        }
    }
    ```

16. inner 内部类是什么意思

    在一个类中，如果在定义一个类，默认情况下，是静态内部类，不能访问外部类的成员

    如果在内部类前面加一个修饰符 inner 那么这个类就变成 非静态内部类，就可以访问外部类的成员变量

    ```kotlin 
    class Outter {
        // 默认是静态内部类
        class Inner {
            fun hello(){
               println("静态内部类 Inner")
            }
        }
    }
    
    class OutterOne {
       val a:Int = 5
       // 用inner 来修饰非静态内部类
       inner class InnerOne {
           val a:Int = 4
           fun hello(){
              pritnln(this.@OutterOne.a) // 5
           }
           fun helloInner(){
              println(this.a) // 4
           }
       }
    }
    ```

17. inline 是什么意思 

    inline 内联函数

    在高阶函数中参数如果是函数类型，则可以接收Lambda表达式，而Lambda表达式在编译时被编译成为一个匿名类，每次调用函数时都会创建一个对象，如果这种函数反复调用，则会创建很多对象，也会带来运行时额外开销，为解决此问题，在 kotlin 中可以将这种函数声明为内联函数

    注意：内联函数在编译时不会生成函数调用代码，而是函数体中的实际代码替换每次调用函数

    inline 一般会出现在参数是lambda表达式的函数这种情况

    ```kotlin 
    inline fun calculatePrint(funN:(Int, Int)->Int){
        println("${funN(10, 5)}")
    }
    calculatePrint {a,b->a+b} // 15
    calculatePrint {a,b->a-b} // 10
    ```

18. 函数式编程--高阶函数和Lambda表达式

    1. 高阶函数 可以作为一个函数类型变量的变量值，前提是`函数类型`的`变量`和高阶函数的`参数列表`和`返回值列表`相同

    ```kotlin 
    fun funAdd(a:Int, b:Int):Int {
        return a + b
    }
    // 或者上面的函数也可以表示成 
    //fun funAdd(a:Int, b:Int) = a +b
    val f1:(Int, Int)->Int =::funAdd
    val result = f1(10, 20) // 30
    ```

    2. 高阶函数 可以作为一个具有函数类型变量的函数参数

    ```kotlin 
    fun funAdd(a:Int, b:Int):Int = a + b
    fun operation(func:(Int, Int)->Int, a:Int, b:Int){
        println("${func(a,b)}")
    }
    operation(::funAdd, 10, 20) // 30
    ```

    3. 高阶函数 可以作为一个函数的返回值

    ```kotlin 
    fun operation(oper:Char):(Int, Int)->Int{
         // 加法函数
         fun add(a:Int, b:Int):Int{
            return a + b
         }     
         // 减法函数
         fun minus(a:Int, b:Int):Int {
            return a-b
         }
         val result:(Int,Int)->Int = 
             when(oper){
                '+'-> ::add
                '-'-> ::minus
                '*'-> {
                    // 乘法匿名函数
                    fun(a:Int, b:Int):Int {
                       return a*b
                    }
                }
                else -> {a,b->(a/b)} // 除法lambda表达式
             }  
         return result
    }
    
    val f1 = operation('+')
    println(f1(10, 5)) // 15 
    val f2 = operation('-')
    println(f2(10, 5)) // 5
    val f3 = operation('*')
    println(f3(10, 5)) // 50
    val f4 = operation('/')
    println(f4(10, 5)) // 2
    ```

    Lambda 常见写法的疑惑解释

    尾随Lambda表达式 

    ```kotlin 
    fun calculatePrint1(funN:(Int, Int)->Int) { // 参数是函数类型
        println("${funN(10,5)}")
    }
    
    // 最后一个参数是函数类型
    fun calculatePrint(n1:Int,n2:Int,opr:Char, funN:(Int, Int)->Int){
        println("${n1} ${opr} ${n2} = ${funN(n1,n2}")
    }
    
    calculatePrint(10, 5, '+', {a, b-> a+b}) // 标准形式
    calculatePrint(10, 5, '-') {a, b-> a-b} // 尾随Lambda表达式
    
    calculatePrint1({a, b}-> a+b) // 标准形式
    calculatePrint1(){a, b -> a + b} // 尾随Lambda表达式
    calculatePrint1{a, b-> a+b } // 如果只有一个函数类型参数,没有其他类型参数，可以省略小括号
    ```

19. 函数引用 分为两种情况：

    1. 顶层函数的引用
    2. 类的成员函数的引用

    ```kotlin 
    // 顶层函数的引用
    fun kLog(tag:String, value:String){
        println("$tag : $value")
    }
    
    val logFunc = ::kLog
    logFunc("KLOG", "Hello World") // KLOG : Hello World
    ```

    ```kotlin 
    // 类的成员函数的引用
    class KLog {
        fun kLog(tag: String, value: String) {
            println("$tag : $value")
        }
    }
    val kLogFunc = KLog::kLog
    val kLog = KLog()
    kLogFunc(kLog, "KLOG", "Hello China") // KLOG : Hello China
    ```

20. 高阶函数一：什么是高阶函数

    高阶函数就是传入或者返回函数的函数

    函数引用 ::println  带有Receiver的引用 pdfPrinter::println 

    ```kotlin 
    class PDFPrinter {
        fun println(any: Any){
            kotlin.io.println(any)
        }
    }
    class Hello {
        fun world(){
            println("Hello world")
        }
    }
    val arr = arrayOf("Jack", "Rose", "Lily")
    arr.forEach(::println)
    // 具名引用到具体的某一个函数 叫具名函数
    // 1. 包机函数
    val hello = Hello::world // 类名加::方法名 就可以限定某个方法了
    hello.invoke(Hello())
    // 2. 类名引用
    arr.filter(String::isNotEmpty)
    // 3. 调用者引用方式
    val pdfPrinter = PDFPrinter()
    arr.forEach(pdfPrinter::println)
    ```

21. let , with, apply 是什么意思

    1. let 是什么 let后面跟一个lambda表达式 如果let之前的对象为不为空，则执行lambda表达式，反之，则不能执行lambda表达式 let 出现的目的就是为了简化一些非空判断 使代码变的更加优雅 注意：kotlin中所有的对象都可以使用let函数

    ```kotlin  
    fun square(num:Int):Int = num*num
    
    var num:Int? = 10 // null
    num?.let { n->println(square(n))}  // num不为空 则执行lambda表达式
    num?.let { println(square{it})} //上一句的lambda表达式的简写 
    ```

    2. with 和 apply  是什么  有时候需要对一个对象设置多个属性，或者调用多个函数式，可以使用with和apply函数，和let一样，kotlin中所有对象都可以使用这两个函数

    ```kotlin 
    fun alphabetWith():String {
        var stringBuilder = StringBuilder()
        return with(stringBuilder){
            for (letter in 'A'..'Z'){
                this.append(letter) // this 代表stringBuffer
            }
            this.append("\n Now I know the alphabet")
            this.toString()
        }
    }
    println(alphabetWith()) // ABCDEFGHIJKLMNOPQRSTUVWXYZ  Now I know the alphabet
    // with返回的值是lambda代码的返回值结果
    val result = with(person){
            "112"
            1
    }
    println(person2) // 1
    ```

    ```kotlin 
    fun alphabetApply():String = StringBuffer().apply {
         for (letter in 'A'..'Z'){
             append(letter)
         }
         append("\n Now I know the alphabet")
    }.toString()
    
    alphabetApply()
    // apply 被声明成一个扩展函数，它的接收者（StringBuffter）变成作为实参的lambda的接收者, apply执行的结果
    // 是StringBuffer
    ```

    总结：

    1. with 返回的值是执行lambda代码的结果，该结果是lambda中最后一个表达式的值 
    2. apply返回的值是lambda接收者的对象 

22. run, also 是什么

    run 函数实际上可以说是let和with两个函数的结合体，run函数只接收一个lambda函数参数，以闭包形式返回，返回值最后一行的值或者指定的return的表达形式

    run 函数的使用场景，适用于let, with函数的任何场景。run函数是let, with 两个函数结合体，准确来说，它弥补了let函数在函数体内必须使用it参数替代对象，在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另外一方面它弥补了with函数传入对象判的问题，在run函数中可以像let函数一样做判空处理

    ```kotlin  
    class User(var name:String, var age:Int, var phoneNum:String)
    val user = User("kotlin", 1, "1212122")
    val result = user?.run {
        println("my name is $name, I am $age years old, my phone number is $phoneNum")
        // my name is kotlin, I am 1 years old, my phone number is 1212122
        1000
    }
    println("result:$result") // result:1000
    ```

    also 函数是什么

    also 函数的结构实际上和let很像唯一的区别就是返回的值不一样，let是以闭包的形式返回，返回函数体内最后一行的值，如果最后一行为空就返回一个Unit类型的默认值，而also函数返回的则是传入的对象本身

    ```kotlin 
    val result ="Hello".also{
            println(it.length) // 5
            1000
    }
    println(result) // Hello
    ```

23. use是什么意思

    use 是针对那些实现了Closeable接口的对象的扩展方法，也就是大部分的IO操作相关类会有这个扩展高阶方法，use 内已经捕获了异常，并调用close方法

    ```kotlin  
    val file = File("Hello.txt")
    if (!file.exists()){
            println("文件不存在")
            return
    }
    println("file ${file.absolutePath}")
    val bufferReader = BufferedReader(FileReader(file))
    bufferReader.use {
        it.readLines().forEach {
                println(it)
        }
    }
    // 注意：测试的时候 文件放到项目根目录下
    ```

24. Map的使用

    map  集合分为 不可变和可变两种 

    ```kotlin 
      val mapOne = mapOf(100 to "Jack", 101 to "Rose", 102 to "Lily")
      val mapTwo = mapOf<Int, String>()
      val mapThree = mapOf(10 to 200)
    
      println(mapOne.size)
      println(mapOne[100])
      println(mapOne.containsKey(100))
      // 遍历所有的key
      for (key in mapOne.keys) {
            println("key=${key} - value = ${mapOne[key]}")
      }
      // 遍历所有的value 
      for (value in mapOne.values){
            println("value = ${value}")
      }
        
      // 遍历所有的key-value
      for ((key, value) in mapOne) {
            println("${key}----${value}")
      }
    
      // mapOne[100] ="" 不可以修改key所对应的value 
      // mutableMapOf 是可变的 可以修改key所对应的value
      val mapFour = mutableMapOf(100 to "Jack")
      mapFour[100] = "John"
    ```

25. 尾递归

    尾递归就是在调用自身之后，没有其他的操作

    ```kotlin 
    data class ListNode(val value:Int, var next:ListNode?)
    
    // 尾递归操作
    tailrec fun findListNode(head:ListNode?, value:Int):ListNode?{
        head?:return null
        if (head.value == value) return head
        return findListNode(head.next, value)
    }
    // 这个阶乘操作不是尾递归
    fun factorial(n:Long):Long{
        return n* factorial(n-1)
    }
    data class TreeNode(val value:Int){
        var left:TreeNode? =null
        var right:TreeNode? = null
    }
    // 这个树的查找不是尾递归 如果是尾递归 可在fun前面加上 tailrec 进行优化 优化操作就是将这个递归变成迭代操作 尾递归容易操作stackOverFlow
    fun findTreeNode(root: TreeNode?, value: Int): TreeNode?{
        root?: return null
        if (root.value == value){
            return root
        }
        return findTreeNode(root.left, value)?: findTreeNode(root.right, value)
    }
    ```

26. observable和map操作

    observable 观察属性变化，相当于每次属性被赋值都会观察变化（初始化也算一次）

    ```kotlin  
    import kotlin.properties.Delegates
    class User{
        var name:String by Delegates.observable("<no name>") {
                prop, old, new ->
            println("$old-> $new")
        }
    }
    val user = User()
    user.name = "Jack"
    user.name = "John"
    // <no name>-> JackJack-> John
    ```

    一个常见的例子就是一个映射（map) 里存储属性的值。这里经常出现在像解析JSON或者其他“动态”事情的引用中，这种情况下，可以使用映射实例自身作为委托来实现委托属性

    ```kotlin 
    class User(val map:Map<String, Any?>){
        val name:String by map
        val gender:String by map
    }
    val user = User(mapOf("name" to "Jack", "gender" to "male"))
    // 读取映射值
    println("${user.name} - ${user.gender}")
    ```

    总结：就是将类本身应该所拥有的属性以键值对形式存储到map里，然后在使用的获取对应的属性值

27. 常见的高阶函数操作

    - map操作

    ```kotlin 
    // map: 将List中每个元素转换成新的元素，并添加到一个新的List中，最后将新List返回
    arrayOf(1,2,3).map { i:Int ->i*10}.forEach(::println) // 10 20 30
    ```

    - flatMap操作

    ```kotlin 
    // flatMap: 将数组中全部元素按顺序组成一个List
    // 注意：lambda 表达式中的参数类型可以不写，如List<String>和IntRange
    listOf(listOf("a", "b"), listOf("c", "d")).flatMap { 
         i:List<String> -> i.asIterable()
    }.forEach(::println) 
    
    println("-----------")
    
    arrayOf(1..3, 1..5).flatMap{
      i:IntRange -> i.asIterable() 
    }.forEach(::println)
    // abcd-----------12312345
    ```

    - fold 操作

    ```kotlin
    // fold: 将集合中的元素依次冒泡组合（进行是某种操作），最终得到一个结构
    // 第一次执行时，由初始值10 作为参数a, 由集合中的第0个参数作为参数b
    // 第二次执行时，第一次执行的返回值作为参数a,由集合中第一个元素作为参数b
    // 依次类推...
    // 最终结果返回
    val foldResult1 = arrayOf(1, 2, 3).fold(10, {a, b-> a+b}) // 计算过程为 10+1+2+3，等于 16
    val foldResult2 = arrayOf(1, 2, 3).fold(10, {a, b-> a*b}) // 计算过程为 10*1*2*3，等于 60
    println(foldResult1)
    println(foldResult2)
    ```

    - reduce操作

    ```kotlin 
    val reduceResult1 = arrayOf(1, 2, 3, 4).reduce({acc, i -> acc+i}) // 计算过程为 1+2+3+4 等于10
    val reduceResult2 = arrayOf(1, 2, 3, 4).reduce({acc, i -> acc*i}) // 计算过程为 1*2*3*4 等于24
    var reduceResult3 = arrayOf("a", "b", "c", "d").reduce({acc, i-> "$acc,$i"})// a,b,c
    ```

    - filter操作 

    ```kotlin 
    // filter 将数组中的元素遍历，把符合要求的元素添加到新的List中，并将新List返回
    // 根据元素过滤
    arrayOf(1, 2, 3, 0, 4 ).filter {i->i>=2} .forEach(::println) // 2 3 4
    // 根据索引过滤
    arrayOf(1, 2, 3, 0, 4 ).filterIndexed{index, i -> index>=2}.forEach(::println) // 3 0 4
    ```

    - takeWhile 操作

    ```kotlin 
    // takeWhile: 遍历list中的元素，将符合要求的元素添加到新集合中
    // 注意：一旦遇到不符合要求的，直接终止
    // 注意：返回的集合中只有4，3 没有5 因为遇到2 不符合要求，就终止遍历了
    arrayOf(4, 3, 2, 5).takeWhile {i -> i>2}.forEach(::println) //  4 3
    ```

28. 科利华是啥东西

    ```kotlin 
    感觉没什么用 暂时不记录了 有用到再记录
    ```

29. 协程相关

    协程是一种轻量级的线程，协程提供了一种不阻塞线程，但是可以被挂起的的计算过程。线程阻塞开销是巨大的，而协程挂起基本上没有开销。线程是系统进行调度，而协程是用户自己进行调度。

    注意：协程是轻量级的线程，因此协程也是由主线程管理的，因此 如果主线程结束那么协程也就结束了。

    - 关键字 delay 

      delay 挂起线程 但是不阻塞

    ```kotlin 
    val job = launch {
      // 启动一个协程
      for（i in 0..9）{
           println("子协程执行第${i}次")
           val sleepTime = (1000*random()).toLong()
           // 协程挂起
           delay(sleepTime)
      }
      println("子协程执行结束")
    }
    println(job.isActive) // true
    println(job.isCompleted) //false
    sleep(10000L) // 主线程休眠，保持其他线程处于活动转态
    println("主线程结束")
    println(job.isCompleted) // true
    ```

    - runBlocking 

    ​       runBlocking 也是可以起一个协程，可以与顶层函数一起使用

    ```kotlin 
    fun main(args:Array<String>) = runBlocking<Unit>{
        val job = launch {
            for (i in 0..9){
                println("子协程执行第${i}次")
                val sleepTime = (1000*random()).toLong()
                // 协程挂起
                delay(sleepTime)
            }
            println("子协程执行结束")
        }
        delay(10000L) // 主协程挂起
        println("主协程结束")
    }
    ```

    - 挂起函数 suspend

      挂起函数必须在协程体中执行或者其他挂起函数中调用，不能在普通函数中调用

    ```kotlin 
    // 挂起函数就是将上面的例子里的协程体中的代码进行了一次封装，便于代码阅读和处理
    suspend fun run(name:String){
        for (i in 0..9){
             println("子协程执行第${i}次")
             val sleepTime = (1000*random()).toLong()
             // 协程挂起
             delay(sleepTime)
        }
        println("子协程执行结束")
    }
    
    fun main(args: Array<String>) = runBlocking<Unit> {
        // 启动一个协程
        val job1 = launch{
            run("job1")
        } 
        val job2 = launch{
            run("job2")
        }
        delay(10000L）// 主协程挂起
        println("主协程结束")      
    }
    ```

    - join 函数

      join  函数在其他协程中被调用，则其他协程只能等待调用join的协程执行结束之后才能继续执行

    ```kotlin  
    fun main()= runBlocking<Unit> {
        val job = GlobalScope.launch {
            delay(1000)
            println("hello world")
        }
        println("hello ")
        job.join()
    }
    ```

    - coroutineScope 协程作用域

      runBlocking 起的协程阻塞当前线程直到启动的子协程结束  而 coroutineScope不会阻塞  delay 100毫秒之后 继续执行后面的输出 `Task from nested launch` 而不会像 runBlocking 那样一直等着 不会立即输出

      `Coroutine scop is over`

    ```kotlin  
    // 作用域构建器
    // runBlocking 与 coroutineScope的主要区别在与后者在等待所有子协程执行完毕时不会阻塞当前线程
    fun main()= runBlocking {
        launch {
            delay(200L)
            println("Task from runBlocking")
        }
        coroutineScope { // 创建一个协程作用域
            launch {
                delay(500L)
                println("Task from nested launch")
            }
            delay(100L)
            println("Task from corountine scope") // 这一行会在内嵌 launch 之前输出
        }
        println("Coroutine scop is over") // 这一行在内嵌 launch 执行完毕后才输出
    }
    ```

    - GlobalScope 使用

    ```kotlin 
    fun main()= runBlocking<Unit> { //开始执行主协程
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L) //非阻塞的等待 1秒钟（默认时间单位是毫秒）
            println("hello world")
        }
        println("hello, ") // 主协程在这里会立即执行
        delay(2000) // 我们延迟了2秒来保证JVM的存活
    }
    ```

    

