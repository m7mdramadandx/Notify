package com.ramadan.notify.domain.use_case.todo

import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.repository.ToDoRepository
import com.ramadan.notify.domain.util.NoteOrder
import com.ramadan.notify.domain.util.OrderType
import com.ramadan.notify.domain.util.ToDoOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetToDos(private val repository: ToDoRepository) {

    operator fun invoke(
        toDoOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    ): Flow<List<ToDo>> {
        return repository.getToDos().map { toDos ->
            when (toDoOrder.orderType) {
                is OrderType.Ascending -> {
                    when (toDoOrder) {
                        is NoteOrder.Title -> toDos.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> toDos.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when (toDoOrder) {
                        is NoteOrder.Title -> toDos.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> toDos.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}