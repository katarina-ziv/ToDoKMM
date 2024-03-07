package com.example.todo.data.task

import com.example.todo.domain.task.Task
import database.TaskEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun TaskEntity.toTask() : Task{
    return Task(
        id = id,
        title = title,
        content = content,
        isDone = isDone,
        colorHex = colorHex,
        created = Instant.fromEpochMilliseconds(created)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    )
}