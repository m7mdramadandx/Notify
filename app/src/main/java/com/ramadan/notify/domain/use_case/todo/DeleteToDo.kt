package com.ramadan.notify.domain.use_case.todo

import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.repository.ToDoRepository

class DeleteToDo(private val repository: ToDoRepository) {

    suspend operator fun invoke(toDo: ToDo) = repository.deleteToDo(toDo)
}