package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AnswerTest {

    lateinit var user: User

    @BeforeEach
    fun setUp () {
        user = User(1, "Kevin", 0)
    }

    @Test
    fun shouldIncreaseVoteWhenVotedUp() {
        val answer = Answer(1, user)
        user.reputation = 10

        answer.vote(VoteEnum.Up)

        Assertions.assertEquals(1, answer.votes)
    }

    @Test
    fun shouldDecreaseVoteWhenVotedDone() {
        val answer = Answer(1, user)

        if(user.reputation == 0) {

        }

        answer.vote(VoteEnum.Down)

        Assertions.assertEquals(-1, answer.votes)

    }
}