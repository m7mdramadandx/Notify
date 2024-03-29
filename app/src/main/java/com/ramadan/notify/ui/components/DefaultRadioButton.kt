package com.ramadan.notify.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramadan.notify.R
import com.ramadan.notify.ui.theme.NotifyTheme

@ExperimentalMaterial3Api
@Composable
fun DefaultRadioButton(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onSelect: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.RadioButton(
            selected = selected,
            onClick = onSelect,
//            colors = RadioButtonDefaults.colors(
//                selectedColor = NotifyTheme.colors.primary,
//                unselectedColor = NotifyTheme.colors.outline
//            )
        )
        androidx.compose.material3.Text(
            text = text,
            fontSize = integerResource(id = R.integer.text_size_xsmall).sp,
        )
    }
}