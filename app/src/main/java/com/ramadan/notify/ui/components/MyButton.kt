package com.ramadan.notify.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramadan.notify.ui.theme.NotifyShape
import com.ramadan.notify.ui.theme.NotifyTheme


@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    padding: Dp = 0.dp,
    textColor: Color = NotifyTheme.colors.title,
    buttonBackground: Color = NotifyTheme.colors.button,
    isEnabled: Boolean = true,
    onClick: () -> (Unit),
) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            disabledElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        modifier = modifier
            .padding(horizontal = padding)
            .fillMaxWidth()
            .height(42.dp),
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = NotifyTheme.colors.buttonInteractive,
            backgroundColor = buttonBackground
        ),
        shape = NotifyShape.shapes.large,
    ) {
        Text(
            text = buttonText,
            style = TextStyle(
                color = textColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            ),
        )
    }
}