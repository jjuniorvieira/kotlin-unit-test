package com.rocksolidknowledge

class Answer(id: Int, user: User) {

    var votes: Int = 0
        private set // private attributes, with public access modified

    fun vote(direction: VoteEnum) {
        when (direction) {
            VoteEnum.Up -> votes++
            VoteEnum.Down -> votes--
        }
    }
}