package com.ramadan.notify.ui.toDos

import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.util.NoteOrder
import com.ramadan.notify.domain.util.ToDoOrder

sealed class ToDosEvent {
    data class Order(val noteOrder: NoteOrder) : ToDosEvent()
    data class DeleteToDo(val todo: ToDo) : ToDosEvent()
    data class MarkToDo(val todo: ToDo) : ToDosEvent()

    object RestoreToDo : ToDosEvent()
    object ToggleOrderSection : ToDosEvent()
    object SaveToDo : ToDosEvent()
}
