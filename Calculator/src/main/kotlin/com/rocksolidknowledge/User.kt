package com.rocksolidknowledge

data class User(val id: Int, val name: String, var reputation: Int) {

    fun questionOrAnswerVotedOn(direction: VoteEnum) {
        when (direction) {
            VoteEnum.Up -> reputation++
            VoteEnum.Down -> reputation--
        }
    }
}

