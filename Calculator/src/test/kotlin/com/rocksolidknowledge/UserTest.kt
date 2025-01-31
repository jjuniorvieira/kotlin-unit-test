@file:Suppress("ClassName")

package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.lang.IllegalArgumentException
import java.util.stream.Stream

class UserArgumentProvider : ArgumentsProvider {
    override fun provideArguments(extensionContext: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(0, "Kevin"),
            Arguments.of(-1, "Kevin"),
            Arguments.of(1, ""),
            Arguments.of(1, " "),
            Arguments.of(1, "\t"),
            Arguments.of(1, "\n"),
        )
    }

}

class `A user` {

    @ParameterizedTest(name = "Id: {0}, Name: {1}")
    @ArgumentsSource(UserArgumentProvider::class)
    fun `should be valid`(id: Int, name: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {User(id, name, 0)}
    }

    @Nested
    inner class `should increase` {

        @Test
        fun `reputation when question or answer is voted up`() {
            val user = User(1, "Kevin", 0)

            user.questionOrAnswerVotedOn(VoteEnum.Up)

            assertEquals(1, user.reputation)
        }

        @Test
        fun `reputation when question or answer is voted up and the user has an initial reputation`() {
            val user = User(1, "Kevin", 10)

            user.questionOrAnswerVotedOn(VoteEnum.Up)

            assertEquals(11, user.reputation)
        }
    }

    @Nested
    inner class `should decrease` {

        @Test
        fun `reputation when question or answer is voted down`() {
            val user = User(1, "Kevin", 0)

            user.questionOrAnswerVotedOn(VoteEnum.Down)

            assertEquals(-1, user.reputation)
        }

        @Test
        fun `reputation when question or answer is voted down and the user has an initial reputation`() {
            val user = User(1, "Kevin", 10)

            user.questionOrAnswerVotedOn(VoteEnum.Down)

            assertEquals(9, user.reputation)
        }
    }

}