package com.ramadan.notify.domain.use_case.todo

import com.ramadan.notify.domain.model.InvalidNoteException
import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.repository.ToDoRepository

class AddToDo(private val repository: ToDoRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(ToDo: ToDo) {
        if (ToDo.title.isBlank()) {
            throw InvalidNoteException("The title of the ToDo can't be empty.")
        }
        repository.insertToDo(ToDo)
    }
}