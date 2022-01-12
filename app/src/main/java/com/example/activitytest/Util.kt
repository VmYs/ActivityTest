package com.example.activitytest

class Util {
    fun doAction1() {
        println("do action1")
    }

    //通过在类里面创建伴生类，doAction2()方法可以直接使用Util.doAction2()的方式调用。
    //不过，doAction2()方法其实也并不是静态方法，companion object这个关键字实际上会在Util类的内部创建一个伴生类，而doAction2()方法就是定义在这个伴生类里面的实例方法。
    //只是Kotlin会保证Util类始终只会存在一个伴生类对象，因此调用Util.doAction2()方法实际上就是调用了Util类中伴生对象的doAction2()方法。
    companion object {

        //通过注解，Kotlin编译器就会将这些方法编译成真正的静态方法
        //@JvmStatic注解只能加在单例类或companion object中的方法上
        @JvmStatic
        fun doAction2(){
            println("do action2")
        }
    }
}