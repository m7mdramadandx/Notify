package com.ramadan.notify.domain.use_case.todo

data class ToDoUseCases(
    val getToDos: GetToDos,
    val deleteToDo: DeleteToDo,
    val addToDo: AddToDo,
    val markToDo: MarkToDo,
    val getToDo: GetToDo,
)
