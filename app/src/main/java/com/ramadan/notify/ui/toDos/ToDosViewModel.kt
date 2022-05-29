package com.ramadan.notify.ui.toDos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramadan.notify.domain.model.InvalidNoteException
import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.use_case.todo.ToDoUseCases
import com.ramadan.notify.domain.util.NoteOrder
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
        getToDos(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: ToDosEvent) {
        when (event) {
            is ToDosEvent.Order -> {
                if (_toDoState.value.noteOrder::class == event.noteOrder::class &&
                    _toDoState.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getToDos(event.noteOrder)
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
                        getToDos(NoteOrder.Date(OrderType.Descending))
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

    private fun getToDos(noteOrder: NoteOrder) {
        getToDosJob?.cancel()
        getToDosJob = toDoUseCases.getToDos(noteOrder)
            .onEach { toDos ->
                _toDoState.value = _toDoState.value.copy(
                    ToDos = toDos,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}