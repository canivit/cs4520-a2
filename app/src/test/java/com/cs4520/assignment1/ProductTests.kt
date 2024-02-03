package com.cs4520.assignment1

import com.cs4520.assignment1.data.Equipment
import com.cs4520.assignment1.data.Food
import com.cs4520.assignment1.data.getProducts
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ProductTests {
    @Test
    fun test_get_products() {
        assertEquals(listOf(
            Equipment("Treadmill", 32),
            Food("Banana", 29, "2024-02-29"),
            Equipment("Dumbbells", 45),
            Food("Apple", 20, "2024-03-10"),
        ), getProducts().take(4).toList())
    }
}