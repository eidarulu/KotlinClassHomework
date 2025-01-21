package com.example.kotlinclasshomework.aPractice

fun main() {
    val numbers = listOf(1, 1, 2, 34, 0, 0, -22, 84, 85, 44, 3)

    println("List of Numbers: $numbers")

    println("Unique Numbers from the List: ${getUniqueNumbers(numbers)}")

    println("Count of Repeats for Each Number: ${getCountOfRepeatsForEachNumber(numbers)}")
}

fun getUniqueNumbers(numbers: List<Int>): Set<Int> {

    val set = mutableSetOf<Int>()

    numbers.forEach {
        set.add(it)
    }

    return set
}

fun getCountOfRepeatsForEachNumber(numbers: List<Int>): Map<Int, Int> {

    val map = mutableMapOf<Int, Int>()

    numbers.forEach {
        val currentCount = map.getOrDefault(it, 0)

        map[it] = currentCount + 1
    }

    return map
}