package com.ramadan.notify.ui.notes

import com.ramadan.notify.domain.model.Note
import com.ramadan.notify.domain.util.ItemOrder
import com.ramadan.notify.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val itemOrder: ItemOrder = ItemOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
)
