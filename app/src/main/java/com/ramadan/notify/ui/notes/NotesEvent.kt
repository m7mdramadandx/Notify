package com.ramadan.notify.ui.notes

import com.ramadan.notify.domain.model.Note
import com.ramadan.notify.domain.util.ItemOrder

sealed class NotesEvent {
    data class Order(val itemOrder: ItemOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}
