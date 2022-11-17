package com.ramadan.notify.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.ramadan.notify.ui.theme.NotifyShape

@Composable
fun NotifyTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
//    onFocusChange: (FocusState) -> Unit,
) {
    androidx.compose.material3.OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged {
//                onFocusChange(it)
            },
        value = text,
        shape = NotifyShape.shapes.large,
        onValueChange = onValueChange,
        label = { Text(text = hint) },
        colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
//            unfocusedBorderColor = NotifyTheme.colors.onSecondary,
//            unfocusedLabelColor = NotifyTheme.colors.onSecondary,
//            focusedBorderColor = NotifyTheme.colors.onPrimary,
//            focusedLabelColor = NotifyTheme.colors.onPrimary,
//            backgroundColor = NotifyTheme.colors.surface,
//            textColor = NotifyTheme.colors.onSurface
        ),
        textStyle = TextStyle(fontSize = 18.sp)
    )

}