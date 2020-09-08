package com.joe.wanandroid.demo

fun main() {
    Person().printName()

}

class Person {
    private val name by lazy {
        "Joe"
    }

    fun printName() {
        println(name)
    }



}