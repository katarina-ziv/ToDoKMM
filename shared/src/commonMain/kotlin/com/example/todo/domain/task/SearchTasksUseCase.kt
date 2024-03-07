package com.example.todo.domain.task

import com.example.todo.domain.time.DateTimeUtil

class SearchTasksUseCase {

   fun execute(tasks: List<Task>, query : String) : List<Task>{
        if(query.isBlank()) return tasks
        return tasks.filter {
            it.title.trim().lowercase().contains(query.lowercase())
                    || it.content.trim().lowercase().contains(query.lowercase())
        }.sortedBy { DateTimeUtil.toEpochMillis(it.created) }
   }
}