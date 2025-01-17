package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("ClassName")
class QuestionTest {

    @Nested
    inner class questions {
        @ParameterizedTest()
        @EmptySource
        @ValueSource(strings = [" ", "   ", "\n", "\t"])
        fun `should have a valid title`(title: String) {
            val user = User(1, "Kevin", 0)


            assertThrows(QuestionException::class.java) { Question(1, user, title, "ggg") }
        }

        @ParameterizedTest
        @EmptySource
        fun `should have a valid discussion`(discussion: String) {
            val user = User(1, "Kevin", 0)


            assertThrows(QuestionException::class.java) { Question(1, user, "fff", discussion) }
        }
    }

}