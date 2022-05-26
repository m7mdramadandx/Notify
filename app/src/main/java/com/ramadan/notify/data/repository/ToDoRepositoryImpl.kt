package com.ramadan.notify.data.repository

import com.ramadan.notify.data.data_source.ToDoDao
import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow

class ToDoRepositoryImpl(
    private val dao: ToDoDao,
) : ToDoRepository {

    override fun getToDos(): Flow<List<ToDo>> {
        return dao.getToDos()
    }

    override suspend fun getToDoById(id: Int): ToDo? {
        return dao.getToDoById(id)
    }

    override suspend fun insertToDo(toDo: ToDo) {
        dao.insertToDo(toDo)
    }

    override suspend fun markToDo(toDo: ToDo) {
        dao.updateToDo(toDo)
    }

    override suspend fun deleteToDo(toDo: ToDo) {
        dao.deleteToDo(toDo)
    }
}