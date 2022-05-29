package com.ramadan.notify.ui.toDos

import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.util.NoteOrder
import com.ramadan.notify.domain.util.OrderType
import com.ramadan.notify.domain.util.ToDoOrder

data class ToDosState(
    val ToDos: List<ToDo> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
)
