package com.ramadan.notify.utils.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp


object NotifyShape {

    val shapes = Shapes(
        small = RoundedCornerShape(12.dp),
        medium = RoundedCornerShape(16.dp),
        large = RoundedCornerShape(28.dp)
    )

    val bottomSheetShape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)

    internal val LocalShapes = staticCompositionLocalOf { shapes }
}
