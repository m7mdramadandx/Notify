package com.ramadan.notify.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ramadan.notify.R

object NotifyTypography {

    val comfortaa = FontFamily(Font(R.font.comfortaa))

    val typography = Typography(
        // 57,45,36
        displayLarge = TextStyle(fontSize = 57.sp, fontFamily = comfortaa),
        displayMedium = TextStyle(fontSize = 45.sp, fontFamily = comfortaa),
        displaySmall = TextStyle(fontSize = 36.sp, fontFamily = comfortaa),

        // 16,14,12
        bodyLarge = TextStyle(fontSize = 18.sp, fontFamily = comfortaa),
        bodyMedium = TextStyle(fontSize = 14.sp, fontFamily = comfortaa),
        bodySmall = TextStyle(fontSize = 12.sp, fontFamily = comfortaa),

        // 22,16,14
        titleLarge = TextStyle(fontSize = 22.sp, fontFamily = comfortaa),
        titleMedium = TextStyle(fontSize = 16.sp, fontFamily = comfortaa),
        titleSmall = TextStyle(fontSize = 14.sp, fontFamily = comfortaa),

        // 32,28,24
        headlineLarge = TextStyle(fontSize = 32.sp, fontFamily = comfortaa),
        headlineMedium = TextStyle(fontSize = 28.sp, fontFamily = comfortaa),
        headlineSmall = TextStyle(fontSize = 24.sp, fontFamily = comfortaa),

        // 14,12,11
        labelLarge = TextStyle(fontSize = 14.sp, fontFamily = comfortaa),
        labelMedium = TextStyle(fontSize = 12.sp, fontFamily = comfortaa),
        labelSmall = TextStyle(fontSize = 11.sp, fontFamily = comfortaa),
    )

    internal val LocalTypography = staticCompositionLocalOf { typography }
}