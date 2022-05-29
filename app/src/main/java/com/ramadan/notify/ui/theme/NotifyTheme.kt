package com.ramadan.notify.ui.theme

import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.ramadan.notify.ui.theme.NotifyShape.LocalShapes
import com.ramadan.notify.ui.theme.NotifyTypography.LocalTypography

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