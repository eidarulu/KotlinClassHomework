package com.example.kotlinclasshomework.aPractice

import java.io.File
import java.io.IOException
import java.io.Reader

fun main() {
    var reader: Reader? = null

    try {
        reader = File("myfile.txt").bufferedReader()
        println(reader.readText())
    } catch (e: IOException) {
        println("Произошла ошибка: ${e.message}")
    } finally { // The finally block is optional and always executed. It is used to release resources.
        println("Конец программы")
        reader?.close()
    }
}

fun throwException() {
    throw Exception("This is an exception")
}

fun throwMyCustomException() {
    throw MyCustomException("My custom exception", Throwable("My custom cause"))
}

// Create a custom exception class that extends the Exception class
class MyCustomException(override val message: String, override val cause: Throwable) : Exception()

/**
 * By default, all exceptions in Kotlin are unchecked exceptions. This means that the compiler does
 * not force you to catch them. You can catch them if you want, but you don't have to.
 * Also, you don't have to declare them in the method signature. and you can throw them anywhere in your code.
 * which is why they are called unchecked exceptions because the compiler does not check them.
 */