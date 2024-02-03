package com.cs4520.assignment1.data



sealed interface Product {
    val name: String
    val price: Int
}

data class Equipment(override val name: String, override val price: Int) :
    Product

data class Food(override val name: String, override val price: Int, val expiryDate: String) :
    Product