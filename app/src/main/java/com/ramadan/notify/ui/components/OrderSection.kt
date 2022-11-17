package com.ramadan.notify.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramadan.notify.R
import com.ramadan.notify.domain.util.ItemOrder
import com.ramadan.notify.domain.util.OrderType
import com.ramadan.notify.utils.UiText

@ExperimentalMaterial3Api
@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    itemOrder: ItemOrder = ItemOrder.Date(OrderType.Descending),
    onOrderChange: (ItemOrder) -> Unit,
) {
    Column(modifier = modifier) {
        Row {
            DefaultRadioButton(
                text = UiText.StringResource(R.string.title).asString(),
                selected = itemOrder is ItemOrder.Title,
                onSelect = { onOrderChange(ItemOrder.Title(itemOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            DefaultRadioButton(
                text = UiText.StringResource(R.string.date).asString(),
                selected = itemOrder is ItemOrder.Date,
                onSelect = { onOrderChange(ItemOrder.Date(itemOrder.orderType)) }
            )
        }
        Row(Modifier.padding(top = 12.dp)) {
            DefaultRadioButton(
                text = UiText.StringResource(R.string.ascending).asString(),
                selected = itemOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(itemOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            DefaultRadioButton(
                text = UiText.StringResource(R.string.descending).asString(),
                selected = itemOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(itemOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}