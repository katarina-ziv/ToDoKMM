package com.example.todo.data.task

import com.example.todo.domain.task.Task
import com.example.todo.domain.task.TaskDataSource

class TaskDataSourceImpl : TaskDataSource {
    override suspend fun insertTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun getTaskById(id: Long): Task? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTasks(): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTaskById(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun updateComplete(isComplete: Boolean) {
        TODO("Not yet implemented")
    }
}