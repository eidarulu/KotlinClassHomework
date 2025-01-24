package com.example.kotlinclasshomework.coroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    runBlocking {
        launch {
            println("running 1")
            yield()
            println("running 3")
            yield()
            println("running 5")
        }
        launch {
            println("running 2")
            yield()
            println("running 4")
        }
    }

}