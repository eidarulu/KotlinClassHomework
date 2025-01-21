package com.example.kotlinclasshomework.allInOneProjects

// Kotlin Project: Zoo Management System

// 1. Regular Class: Represents a blueprint for objects with properties and functions.
class Animal(val name: String, val species: String) {
    fun eat(food: String) {
        println("\$name the \$species is eating \$food.")
    }
}

// 2. Data Class: Used to hold data with automatic equals, hashCode, toString, and copy functions.
data class ZooKeeper(val name: String, val age: Int)

// 3. Enum Class: Represents a fixed set of constants, often used for predefined categories or states.
enum class AnimalType {
    MAMMAL, BIRD, REPTILE, FISH, AMPHIBIAN, INSECT
}

// 4. Sealed Class: Restricts the hierarchy to a fixed set of subclasses, useful for representing limited types.
sealed class Cage {
    data class SmallCage(val capacity: Int) : Cage()
    data class LargeCage(val capacity: Int) : Cage()
    object Empty : Cage() // Represents an empty cage
}

// 5. Abstract Class: Serves as a base class with abstract methods to be implemented by subclasses.
abstract class Worker(val id: Int) {
    abstract fun performDuties()
}

// Subclass of Abstract Class
class Veterinarian(id: Int, val specialization: String) : Worker(id) {
    override fun performDuties() {
        println("Veterinarian with ID \$id is treating animals specializing in \$specialization.")
    }
}

// 6. Interface: Defines a contract that classes must implement, useful for multiple inheritance.
interface Cleanable {
    fun clean()
}

// Implementing Interface
class CageCleaner(val cleanerName: String) : Cleanable {
    override fun clean() {
        println("\$cleanerName is cleaning the cages.")
    }
}

// 7. Object: A singleton that provides a single instance of a class, often used for utilities or global state.
object ZooManager {
    val animals = mutableListOf<Animal>()
    fun addAnimal(animal: Animal) {
        animals.add(animal)
        println("\${animal.name} the \${animal.species} has been added to the zoo.")
    }
}

// 8. Companion Object: Provides static-like functionality for its enclosing class.
class Ticket(val price: Double) {
    companion object {
        const val STANDARD_PRICE = 20.0
        fun printWelcomeMessage() {
            println("Welcome to the Zoo! Enjoy your visit.")
        }
    }
}

// Main function to demonstrate the usage of all object groups.
fun main() {
    // Regular Class
    val lion = Animal("Leo", "Lion")
    lion.eat("meat")

    // Data Class
    val keeper = ZooKeeper("John", 30)
    println("ZooKeeper: \$keeper")

    // Enum Class
    val animalType = AnimalType.MAMMAL
    println("Animal type: \$animalType")

    // Sealed Class
    val cage: Cage = Cage.LargeCage(10)
    when (cage) {
        is Cage.SmallCage -> println("Small cage with capacity: \${cage.capacity}")
        is Cage.LargeCage -> println("Large cage with capacity: \${cage.capacity}")
        Cage.Empty -> println("The cage is empty.")
    }

    // Abstract Class
    val vet = Veterinarian(1, "Large Animals")
    vet.performDuties()

    // Interface
    val cleaner = CageCleaner("Alice")
    cleaner.clean()

    // Object
    ZooManager.addAnimal(lion)

    // Companion Object
    Ticket.printWelcomeMessage()
    println("Standard ticket price: \$${Ticket.STANDARD_PRICE}")
}