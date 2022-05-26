package com.ramadan.notify.utils.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

//    val colorScheme: ColorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//        darkTheme -> MyColor.DarkColorPalette
//        else -> MyColor.LightColorPalette
//    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            (view.context as Activity).window.statusBarColor = ColorScheme.primary.toArgb()
//            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
//        }
//    }
//


    val colors = if (darkTheme) MyColor.DarkColorPalette else MyColor.LightColorPalette
    val notifyColors =
        if (darkTheme) MyColor.NotifyDarkColorPalette else MyColor.NotifyLightColorPalette

    SideEffect {
        systemUiController.setStatusBarColor(color = notifyColors.appBar)
        systemUiController.setNavigationBarColor(color = colors.onSurface)
    }

    ProvideNotifyColors(notifyColors) {
        MaterialTheme(
            colors = colors,
            typography = NotifyTypography.typography,
            shapes = NotifyShape.shapes,
            content = content
        )
    }
}

@Composable
private fun ProvideNotifyColors(
    colors: NotifyColors,
    content: @Composable () -> Unit,
) {
    val notifyColors = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    notifyColors.update(colors)
    CompositionLocalProvider(MyColor.localNotifyColors provides notifyColors, content = content)

}