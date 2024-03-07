package com.example.todo.data.task

import com.example.todo.database.TodoDatabase
import com.example.todo.domain.task.Task
import com.example.todo.domain.task.TaskDataSource
import com.example.todo.domain.time.DateTimeUtil

class TaskDataSourceImpl(todoDb : TodoDatabase) : TaskDataSource {

    private var queries = todoDb.taskQueries
    override suspend fun insertTask(task: Task) {
        queries.insertTask(
            id = task.id,
            title = task.title,
            content = task.content,
            colorHex = task.colorHex,
            created = DateTimeUtil.toEpochMillis(task.created)
        )

    }

    override suspend fun getTaskById(id: Long): Task? {
        return queries
            .getTaskById(id)
            .executeAsOneOrNull()
            ?.toTask()
    }

    override suspend fun getAllTasks(): List<Task> {
        return queries.getAllTasks().executeAsList().map { it.toTask() }
    }

    override suspend fun deleteTaskById(id: Long) {
        queries.deleteTaskById(id)
    }

    override suspend fun updateComplete(isComplete: Boolean,id : Long) {
        queries.updateComplete(isComplete, id)
    }

    override suspend fun getDoneTasks(): List<Task> {
        return queries.getDoneTasks().executeAsList().map { it.toTask() }
    }
}