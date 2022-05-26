package com.ramadan.notify.utils.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ramadan.notify.R

// Set of Material typography styles to start with
object NotifyTypography {
    val typography = Typography(
        defaultFontFamily = FontFamily(
            Font(R.font.comfortaa),
            Font(R.font.comfortaa, FontWeight.Bold)
        ),
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        button = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        caption = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )

    internal val LocalTypography = staticCompositionLocalOf { typography }
}