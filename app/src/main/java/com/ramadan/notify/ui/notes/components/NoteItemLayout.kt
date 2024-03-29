package com.ramadan.notify.ui.notes.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.ramadan.notify.R
import com.ramadan.notify.ui.components.NotifyCard
import com.ramadan.notify.ui.theme.NotifyTheme

@Composable
fun NoteItemLayout(modifier: Modifier, noteColor: Int) {
    val cornerRadius: Dp = 15.dp
    val cutCornerSize: Dp = 30.dp

    Canvas(modifier = modifier) {
        val clipPath = Path().apply {
            lineTo(size.width - cutCornerSize.toPx(), 0f)
            lineTo(size.width, cutCornerSize.toPx())
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }

        clipPath(clipPath) {
            drawRoundRect(
                color = Color(noteColor),
                size = size,
                cornerRadius = CornerRadius(cornerRadius.toPx())
            )
            drawRoundRect(
                color = Color(
                    ColorUtils.blendARGB(noteColor, 0x000000, 0.2f)
                ),
                topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                size = Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                cornerRadius = CornerRadius(cornerRadius.toPx())
            )
        }
    }
}