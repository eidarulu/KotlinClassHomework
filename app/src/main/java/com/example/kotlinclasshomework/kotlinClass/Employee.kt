package com.example.kotlinclasshomework.kotlinClass

open class Employee(name: String) {

    constructor(name: String, company: String) : this(name) {
        println("Меня зовут $name, я работаю в компании $company")
    }

    fun work() {
        println("Усердно работаю")
    }

    open fun haveLunch() {
        println("Иду на обед в 13.00")
    }

    open fun goHome() {
        println("Иду домой в 19.00")
    }
}

class AndroidDeveloper() : Employee("Yeldos Amire", "Kolesa Group") {

    override fun haveLunch() {
        super.haveLunch()
        println("А потом еще и за кофеечком")
    }

    override fun goHome() {
        println("Еду домой на Kia K5")
    }
}