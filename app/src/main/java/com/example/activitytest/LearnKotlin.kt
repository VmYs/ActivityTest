package com.example.activitytest

import java.lang.StringBuilder

fun main() {
//    //无脑实现“吃水果”
//    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
//    val builder = StringBuilder()
//    builder.append("Start eating fruits.\n")
//    for (fruit in list) {
//        builder.append(fruit).append("\n")
//    }
//    builder.append("Ate all fruits.")
//    val result = builder.toString()
//    println(result)

    //通过Kotlin标准函数with()简化
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
    println(result)

    //通过Kotlin标准函数run()实现
    val result2 = StringBuilder().run {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
    println(result2)

    //通过Kotlin标准函数apply()实现
    val result3 = StringBuilder().apply {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    //由于apply函数只能返回对象本身，不能指定返回值，因此只能在函数外转换result3的数据类型
    println(result3.toString())
}