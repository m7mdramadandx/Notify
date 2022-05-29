package com.ramadan.notify.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp


object NotifyShape {

    val shapes = androidx.compose.material3.Shapes(
        extraSmall = RoundedCornerShape(5.dp),
        small = RoundedCornerShape(10.dp),
        medium = RoundedCornerShape(15.dp),
        large = RoundedCornerShape(25.dp),
        extraLarge = RoundedCornerShape(35.dp)
    )

    val bottomSheetShape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)

    internal val LocalShapes = staticCompositionLocalOf { shapes }
}
