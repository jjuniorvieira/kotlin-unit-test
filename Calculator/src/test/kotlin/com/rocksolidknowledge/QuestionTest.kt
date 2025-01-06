package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QuestionTest {

    @Test
    fun `should have a valid title`() {
        val user = User(1, "Kevin", 0)


        assertThrows(QuestionException::class.java) { Question(1, user, "", "ggg") }
    }

    @Test
    fun `should have a valid discussion`() {
        val user = User(1, "Kevin", 0)


        assertThrows(QuestionException::class.java) { Question(1, user, "fff", "") }
    }

}