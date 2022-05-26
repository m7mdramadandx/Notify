package com.ramadan.notify.utils.theme

import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.ramadan.notify.utils.theme.NotifyShape.LocalShapes
import com.ramadan.notify.utils.theme.NotifyTypography.LocalTypography

object NotifyTheme {

    val colors: NotifyColors
        @Composable
        @ReadOnlyComposable
        get() = MyColor.localNotifyColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: Shapes
        @ReadOnlyComposable
        @Composable
        get() = LocalShapes.current

}