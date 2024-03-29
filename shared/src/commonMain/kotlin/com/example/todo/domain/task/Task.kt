package com.example.todo.domain.task

import kotlinx.datetime.LocalDateTime

data class Task(
    val id: Long?,
    val title: String,
    val content: String,
    val isDone: Boolean,
    val colorHex: Long,
    val created: LocalDateTime
)
