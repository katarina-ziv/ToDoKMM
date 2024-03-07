package com.example.todo.domain.task

interface TaskDataSource {
    suspend fun insertTask(task: Task)
    suspend fun getTaskById(id: Long) : Task?

    suspend fun getAllTasks() : List<Task>
    //Moze da se vrati flow koji se trigeruje kad se desi promjena u bazi

    suspend fun deleteTaskById(id: Long)

    suspend fun updateComplete(isComplete : Boolean,id: Long)
    suspend fun getDoneTasks() : List<Task>
}