package com.ramadan.notify.ui.toDos

import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.domain.util.ItemOrder
import com.ramadan.notify.domain.util.OrderType

data class ToDosState(
    val ToDos: List<ToDo> = emptyList(),
    val itemOrder: ItemOrder = ItemOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
)
