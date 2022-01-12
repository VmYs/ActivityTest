package com.example.activitytest;


public class JavaTest {
    public void invokeStaticMethod() {
        //Java调用Kotlin定义的静态方法，之前的Helper.kt会自动创建一个HelperKt类，静态方法就是定义在这个类中。
        HelperKt.doSomething();
    }
}
