package com.ramadan.notify.ui.toDos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramadan.notify.domain.model.InvalidNoteException
import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.use_case.todo.ToDoUseCases
import com.ramadan.notify.domain.util.ItemOrder
import com.ramadan.notify.domain.util.OrderType
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
        getToDos(ItemOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: ToDosEvent) {
        when (event) {
            is ToDosEvent.Order -> {
                if (_toDoState.value.itemOrder::class == event.itemOrder::class &&
                    _toDoState.value.itemOrder.orderType == event.itemOrder.orderType
                ) {
                    return
                }
                getToDos(event.itemOrder)
            }
            is ToDosEvent.DeleteToDo -> {
                viewModelScope.launch {
                    toDoUseCases.deleteToDo(event.todo)
                    recentlyDeletedToDo = event.todo
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
                        toDoUseCases.markToDo(event.todo.copy(isDone = true))
                        getToDos(ItemOrder.Date(OrderType.Descending))
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

    private fun getToDos(itemOrder: ItemOrder) {
        getToDosJob?.cancel()
        getToDosJob = toDoUseCases.getToDos(itemOrder)
            .onEach { toDos ->
                _toDoState.value = _toDoState.value.copy(
                    ToDos = toDos,
                    itemOrder = itemOrder
                )
            }
            .launchIn(viewModelScope)
    }
}