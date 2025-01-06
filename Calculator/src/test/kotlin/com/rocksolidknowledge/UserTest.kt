package com.rocksolidknowledge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserTest {

    @Test
    fun shouldIncreaseReputationWhenQuestionOrAnswerIsVotedUp() {
        val user = User(1, "Kevin", 0)

        user.questionOrAnswerVotedOn(VoteEnum.Up)

        assertEquals(1, user.reputation)
    }

    @Test
    fun shouldIncreaseReputationWhenQuestionOrAnswerIsVotedUpAndTheUserHasAnInitialReputation() {
        val user = User(1, "Kevin", 10)

        user.questionOrAnswerVotedOn(VoteEnum.Up)

        assertEquals(11, user.reputation)
    }

    @Test
    fun shouldDecreaseReputationWhenQuestionOrAnswerIsVotedDown() {
        val user = User(1, "Kevin", 0)

        user.questionOrAnswerVotedOn(VoteEnum.Down)

        assertEquals(-1, user.reputation)
    }

    @Test
    fun shouldDecreaseReputationWhenQuestionOrAnswerIsVotedDownAndTheUserHasAnInitialReputation() {
        val user = User(1, "Kevin", 10)

        user.questionOrAnswerVotedOn(VoteEnum.Down)

        assertEquals(9, user.reputation)
    }

}