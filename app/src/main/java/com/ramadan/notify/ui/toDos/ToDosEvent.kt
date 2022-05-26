package com.ramadan.notify.ui.toDos

import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.util.ToDoOrder

sealed class ToDosEvent {
    data class Order(val ToDoOrder: ToDoOrder) : ToDosEvent()
    data class DeleteToDo(val ToDo: ToDo) : ToDosEvent()
    data class MarkToDo(val ToDo: ToDo) : ToDosEvent()

    object RestoreToDo : ToDosEvent()
    object ToggleOrderSection : ToDosEvent()
    object SaveToDo : ToDosEvent()
}
