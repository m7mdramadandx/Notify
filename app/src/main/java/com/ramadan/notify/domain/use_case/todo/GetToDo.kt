package com.ramadan.notify.domain.use_case.todo

import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.repository.ToDoRepository

class GetToDo(private val repository: ToDoRepository) {

    suspend operator fun invoke(id: Int): ToDo? = repository.getToDoById(id)
}