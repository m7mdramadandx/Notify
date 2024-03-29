package com.ramadan.notify.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import com.ramadan.notify.R
import com.ramadan.notify.ui.theme.NotifyTheme

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    value: String,
    label: String,
    textStyle: TextStyle = NotifyTheme.typography.bodyMedium,
    background: Color = MaterialTheme.colorScheme.surface,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: (KeyboardActionScope) -> Unit = {},
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    onClick: () -> Unit = {},
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
) {

    var _label by remember { mutableStateOf("") }
    _label = label
    if (value.isNotEmpty()) _label = ""

    androidx.compose.material3.TextField(
        enabled = isEnable,
        value = value,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        keyboardActions = KeyboardActions(onDone = keyboardActions),
        onValueChange = {
            onValueChange(it)
            if (it.isNotEmpty()) _label = ""
        },
        trailingIcon = trailingIcon,
        readOnly = readOnly,
        label = {
            Text(
                text = _label,
//                color = NotifyTheme.colors.onSurface,
            )
        },
        singleLine = singleLine,
//        colors = androidx.compose.material3.TextFieldDefaults.textFieldColors(
//            containerColor = background,
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent,
//            disabledTextColor = NotifyTheme.colors.onPrimary,
//            textColor = NotifyTheme.colors.onPrimary,
//        ),
//        textStyle = textStyle,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(start = dimensionResource(id = R.dimen.padding_medium))
            .onFocusChanged {
                if (it.isFocused || it.hasFocus || it.isCaptured) _label = ""
            },
    )
}