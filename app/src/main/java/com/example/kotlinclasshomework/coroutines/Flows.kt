package com.example.kotlinclasshomework.coroutines

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    // 1. Creating a simple flow
    val simpleFlow = flow {
        for (i in 1..5) {
            delay(100) // Simulate asynchronous work
            emit(i) // Emit values one by one
        }
    }

    // Collecting the flow
    println("Collecting simple flow:")
    simpleFlow.collect { value ->
        println("Received: $value")
    }

    // 2. Transforming a flow
    val transformedFlow = simpleFlow.map { value ->
        value * value // Square each emitted value
    }

    println("\nCollecting transformed flow:")
    transformedFlow.collect { value ->
        println("Received: $value")
    }

    // 3. Filtering a flow
    val filteredFlow = simpleFlow.filter { value ->
        value % 2 == 0 // Only allow even numbers
    }

    println("\nCollecting filtered flow:")
    filteredFlow.collect { value ->
        println("Received: $value")
    }

    // 4. Combining flows
    val flow1 = flowOf(1, 2, 3)
    val flow2 = flowOf("A", "B", "C")

    println("\nCombining flows:")
    flow1.zip(flow2) { int, str ->
        "$int -> $str" // Combine integer and string
    }.collect { combinedValue ->
        println("Received: $combinedValue")
    }

    // 5. Handling exceptions
    val errorFlow = flow {
        emit(1)
        emit(2)
        throw RuntimeException("Flow error!") // Emit an error
    }

    println("\nHandling exceptions:")
    errorFlow.catch { e ->
        println("Caught exception: ${e.message}")
    }.collect { value ->
        println("Received: $value")
    }

    // 6. Flow cancellation
    val cancellableFlow = flow {
        for (i in 1..5) {
            delay(500)
            println("Emitting $i")
            emit(i)
        }
    }

    println("\nFlow cancellation:")
    val job = launch {
        cancellableFlow.collect { value ->
            println("Received: $value")
        }
    }

    delay(1200) // Let the flow emit some values
    println("Cancelling the flow")
    job.cancelAndJoin() // Cancel the flow

    // 7. Flow operators (e.g., reduce)
    val reducedResult = simpleFlow.reduce { accumulator, value ->
        accumulator + value // Sum all emitted values
    }

    println("\nReduced result: $reducedResult")

    // 8. StateFlow (Hot flow example)
    val stateFlow = MutableStateFlow(0)

    println("\nStateFlow example:")
    val stateJob = launch {
        stateFlow.collect { value ->
            println("StateFlow emitted: $value")
        }
    }

    stateFlow.value = 1 // Update value
    delay(100)
    stateFlow.value = 2 // Update value again
    delay(100)
    stateJob.cancel()

    // 9. SharedFlow (Hot flow example)
    val sharedFlow = MutableSharedFlow<Int>()

    println("\nSharedFlow example:")
    val sharedJob = launch {
        sharedFlow.collect { value ->
            println("SharedFlow emitted: $value")
        }
    }

    sharedFlow.emit(10)
    sharedFlow.emit(20)
    delay(100)
    sharedJob.cancel()
}
