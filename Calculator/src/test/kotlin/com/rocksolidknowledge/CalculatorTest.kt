package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun shouldAddTwoNumbers() {
        val calc = Calculator()
        val result: Int = calc.add(23, 45)

        assertEquals(68, result)
    }

    @Test
    fun shouldSubtractTwoNumbers() {
        val calc = Calculator()
        val result: Int = calc.subtract(23, 45)

        assertEquals(-22, result)

    }

}