package com.ramadan.notify.ui.toDos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramadan.notify.domain.model.InvalidNoteException
import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.use_case.todo.ToDoUseCases
import com.ramadan.notify.domain.util.OrderType
import com.ramadan.notify.domain.util.ToDoOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDosViewModel @Inject constructor(
    private val toDoUseCases: ToDoUseCases,
) : ViewModel() {

    private val _toDoState = mutableStateOf(ToDosState())
    val toDoState: State<ToDosState> = _toDoState

    var toDoTitle = mutableStateOf("")

    private var recentlyDeletedToDo: ToDo? = null

    private var getToDosJob: Job? = null

    init {
        getToDos(ToDoOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: ToDosEvent) {
        when (event) {
            is ToDosEvent.Order -> {
                if (_toDoState.value.toDoOrder::class == event.ToDoOrder::class &&
                    _toDoState.value.toDoOrder.orderType == event.ToDoOrder.orderType
                ) {
                    return
                }
                getToDos(event.ToDoOrder)
            }
            is ToDosEvent.DeleteToDo -> {
                viewModelScope.launch {
                    toDoUseCases.deleteToDo(event.ToDo)
                    recentlyDeletedToDo = event.ToDo
                }
            }
            is ToDosEvent.RestoreToDo -> {
                viewModelScope.launch {
                    toDoUseCases.addToDo(recentlyDeletedToDo ?: return@launch)
                    recentlyDeletedToDo = null
                }
            }
            is ToDosEvent.ToggleOrderSection -> {
                _toDoState.value = _toDoState.value.copy(
                    isOrderSectionVisible = !_toDoState.value.isOrderSectionVisible
                )
            }

            is ToDosEvent.MarkToDo -> {
                viewModelScope.launch {
                    try {
                        toDoUseCases.markToDo(event.ToDo.copy(isDone = true))
                        getToDos(ToDoOrder.Date(OrderType.Descending))
                    } catch (e: InvalidNoteException) {
                    }
                }
            }
            ToDosEvent.SaveToDo -> {
                viewModelScope.launch {
                    try {
                        toDoUseCases.addToDo(
                            ToDo = ToDo(
                                title = toDoTitle.value,
                                isDone = false,
                                timestamp = System.currentTimeMillis()
                            )
                        )
                    } catch (e: InvalidNoteException) {
                    }
                }
            }
        }
    }

    private fun getToDos(ToDoOrder: ToDoOrder) {
        getToDosJob?.cancel()
        getToDosJob = toDoUseCases.getToDos(ToDoOrder)
            .onEach { toDos ->
                _toDoState.value = _toDoState.value.copy(
                    ToDos = toDos,
                    toDoOrder = ToDoOrder
                )
            }
            .launchIn(viewModelScope)
    }
}