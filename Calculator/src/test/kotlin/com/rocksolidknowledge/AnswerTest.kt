package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AnswerTest {

    val user = User(1, "Kevin", 0)

    @Test
    fun shouldIncreaseVoteWhenVotedUp() {
        val answer = Answer(1, user)

        answer.vote(VoteEnum.Up)

        Assertions.assertEquals(1, answer.votes)
    }

    @Test
    fun shouldDecreaseVoteWhenVotedDone() {
        val answer = Answer(1, user)

        answer.vote(VoteEnum.Down)

        Assertions.assertEquals(-1, answer.votes)

    }
}