package com.ramadan.notify.domain.repository

import com.ramadan.notify.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {

    fun getToDos(): Flow<List<ToDo>>

    suspend fun getToDoById(id: Int): ToDo?

    suspend fun insertToDo(toDo: ToDo)

    suspend fun markToDo(toDo: ToDo)

    suspend fun deleteToDo(toDo: ToDo)
}