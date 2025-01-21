package com.example.kotlinclasshomework.kotlinClass

data class Person(val name: String, val age: Int)

class Person2(val name: String, val age: Int)

fun main() {
    val person = Person("Yeldos", 20)
    println(person)
    println(person.toString())

    val person2 = Person2("Yeldos", 20)
    println(person2)
    println(person2.toString())
}