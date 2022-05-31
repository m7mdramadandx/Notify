package com.ramadan.notify.domain.use_case.note

import com.ramadan.notify.domain.model.Note
import com.ramadan.notify.domain.repository.NoteRepository
import com.ramadan.notify.domain.util.ItemOrder
import com.ramadan.notify.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {

    operator fun invoke(
        itemOrder: ItemOrder = ItemOrder.Date(OrderType.Descending),
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (itemOrder.orderType) {
                is OrderType.Ascending -> {
                    when (itemOrder) {
                        is ItemOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is ItemOrder.Date -> notes.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when (itemOrder) {
                        is ItemOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is ItemOrder.Date -> notes.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}