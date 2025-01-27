package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource

@Suppress("ClassName")
class QuestionTest {

    @Nested
    inner class `questions with csv source` {
        @ParameterizedTest()
        @CsvFileSource(resources = ["/questions.csv"], useHeadersInDisplayName = true, numLinesToSkip = 1)
        fun `should be valid`(title: String, discussion: String) {
            val user = User(1, "Kevin", 0)


            assertThrows(QuestionException::class.java) { Question(1, user, title, discussion) }
        }

    }

    @Nested
    inner class questions {
        @ParameterizedTest()
        @CsvSource(
            "'', discussion",
            "' ', discussion",
            "'\n', discussion",
            "'\t', discussion",
            "title, ''",
            "title, ' '",
            "title, '\n'",
            "title, '\t'",
        )
        fun `should be valid`(title: String, discussion: String) {
            val user = User(1, "Kevin", 0)


            assertThrows(QuestionException::class.java) { Question(1, user, title, discussion) }
        }

    }


}