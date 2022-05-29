package com.ramadan.notify.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.ramadan.notify.R
import com.ramadan.notify.domain.util.NoteOrder
import com.ramadan.notify.domain.util.OrderType
import com.ramadan.notify.utils.UiText

@Composable
fun OrderSection(
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit,
) {
    Column(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))) {
        Row {
            DefaultRadioButton(
                text = UiText.StringResource(R.string.title).asString(),
                selected = noteOrder is NoteOrder.Title,
                onSelect = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            DefaultRadioButton(
                text = UiText.StringResource(R.string.date).asString(),
                selected = noteOrder is NoteOrder.Date,
                onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
            )
        }
        Row {
            DefaultRadioButton(
                text = UiText.StringResource(R.string.ascending).asString(),
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            DefaultRadioButton(
                text = UiText.StringResource(R.string.descending).asString(),
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}