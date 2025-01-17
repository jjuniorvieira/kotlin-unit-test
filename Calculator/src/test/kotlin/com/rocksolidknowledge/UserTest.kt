@file:Suppress("ClassName")

package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class `A user` {

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