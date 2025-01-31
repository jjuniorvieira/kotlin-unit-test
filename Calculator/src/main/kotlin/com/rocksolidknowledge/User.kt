package com.rocksolidknowledge

data class User(val id: Int, val name: String, var reputation: Int) {

    init {
        if(id <= 0) throw IllegalArgumentException()
        if(name.trim().isEmpty()) throw IllegalArgumentException()
    }

    fun questionOrAnswerVotedOn(direction: VoteEnum) {
        when (direction) {
            VoteEnum.Up -> reputation++
            VoteEnum.Down -> reputation--
        }
    }
}

