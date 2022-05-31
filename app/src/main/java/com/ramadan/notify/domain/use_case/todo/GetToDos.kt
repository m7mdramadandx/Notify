package com.ramadan.notify.domain.use_case.todo

import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.repository.ToDoRepository
import com.ramadan.notify.domain.util.ItemOrder
import com.ramadan.notify.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetToDos(private val repository: ToDoRepository) {

    operator fun invoke(
        toDoOrder: ItemOrder = ItemOrder.Date(OrderType.Descending),
    ): Flow<List<ToDo>> {
        return repository.getToDos().map { toDos ->
            when (toDoOrder.orderType) {
                is OrderType.Ascending -> {
                    when (toDoOrder) {
                        is ItemOrder.Title -> toDos.sortedBy { it.title.lowercase() }
                        is ItemOrder.Date -> toDos.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when (toDoOrder) {
                        is ItemOrder.Title -> toDos.sortedByDescending { it.title.lowercase() }
                        is ItemOrder.Date -> toDos.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}