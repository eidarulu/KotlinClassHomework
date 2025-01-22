package com.example.kotlinclasshomework.aLibEx
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class User(val id: Int, val name: String, val email: String)

// Сериализация объекта в строку JSON
val user = User(id = 1, name = "Yeldos Amire", email = "eidarulu@gmail.com")

val jsonString = Json.encodeToString(user)

// Десериализация строки JSON обратно в объект.
val jsonStringToDeserialize = """
    {
    "id": 1,
    "name": "Yeldos Amire",
    "email": "eidarulu@gmail.com"
    }
""".trimIndent()

val deserializedUser = Json.decodeFromString<User>(jsonStringToDeserialize)

fun main() {
    println(jsonString) // {"id":1,"name":"Yeldos Amire","email":"eidarulu@gmail.com"}
    println(deserializedUser) // User(id=1, name=Yeldos Amire, email=eidarulu@gmail.com)
}
