package com.ramadan.notify.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.ramadan.notify.ui.theme.NotifyShape
import com.ramadan.notify.ui.theme.NotifyTheme

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
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged {
//                onFocusChange(it)
            },
        value = text,
        shape = NotifyShape.shapes.large,
        onValueChange = onValueChange,
        label = { Text(text = hint) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = NotifyTheme.colors.textSecondary,
            unfocusedLabelColor = NotifyTheme.colors.textSecondary,
            focusedBorderColor = NotifyTheme.colors.textPrimary,
            focusedLabelColor = NotifyTheme.colors.textPrimary,
            backgroundColor = NotifyTheme.colors.textFieldBg,
            textColor = NotifyTheme.colors.textPrimary
        ),
        textStyle = TextStyle(fontSize = 18.sp)
    )

}