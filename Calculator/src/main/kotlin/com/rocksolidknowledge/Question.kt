package com.rocksolidknowledge

class Question(val id: Int, user: User, title: String, discussion: String) {

    init {
        if(title.trim().isEmpty()) throw QuestionException()
        if(discussion.trim().isEmpty()) throw QuestionException()
    }
}