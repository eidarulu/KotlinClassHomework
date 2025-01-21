package com.example.kotlinclasshomework.sealedClass

sealed class PurchaseStatus {

    object InProgress: PurchaseStatus()

    object Ready: PurchaseStatus()

    data class Canceled(val reason: String): PurchaseStatus()
}