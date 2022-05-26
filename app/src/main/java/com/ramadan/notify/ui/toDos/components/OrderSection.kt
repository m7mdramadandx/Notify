package com.ramadan.notify.ui.toDos.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramadan.notify.domain.util.OrderType
import com.ramadan.notify.domain.util.ToDoOrder

@Composable
fun OrderSection(
    toDoOrder: ToDoOrder = ToDoOrder.Date(OrderType.Descending),
    onOrderChange: (ToDoOrder) -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = toDoOrder is ToDoOrder.Title,
                onSelect = { onOrderChange(ToDoOrder.Title(toDoOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = toDoOrder is ToDoOrder.Date,
                onSelect = { onOrderChange(ToDoOrder.Date(toDoOrder.orderType)) }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = toDoOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(toDoOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = toDoOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(toDoOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}