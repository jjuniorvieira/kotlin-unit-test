package com.rocksolidknowledge

class Answer(id: Int, user: User) {

    var votes: Int = 0
        private set

    fun vote(direction: VoteEnum) {
        when (direction) {
            VoteEnum.Up -> votes++
            VoteEnum.Down -> votes--
        }
    }
}