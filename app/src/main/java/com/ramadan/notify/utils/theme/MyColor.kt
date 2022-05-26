package com.ramadan.notify.utils.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object MyColor {

    val RedOrange = Color(0xffffab91)
    val RedPink = Color(0xfff48fb1)
    val BabyBlue = Color(0xff81deea)
    val Violet = Color(0xffcf94da)
    val LightGreen = Color(0xffe7ed9b)

    val localNotifyColors = staticCompositionLocalOf<NotifyColors> {
        error("No NotifyColorPalette provided")
    }

    private val appBar = Color(0xFF417D7A)
    private val appBarDark = Color(0xFF111111)
    private val background = Color(0xFFEDE6DB)
    private val backgroundDark = Color(0xFF111111)
    private val popUp = Color(0xFFFDFDFD)
    private val popUpDark = Color(0xFF1B1B1B)
    private val textFieldBg = Color(0xFFFDFDFD)
    private val textFieldBgDark = Color(0xFF252525)
    private val cardBg = Color(0xFFF5F5F5)
    private val cardBgDark = Color(0xFF252525)
    private val title = Color(0xFFFFFFFF)
    private val titleDark = Color(0xFFFFFFFF)
    private val textPrimary = Color(0xFF000000)
    private val textPrimaryDark = Color(0xFFFFFFFF)
    private val textButton = Color(0xFF1A3C40)
    private val textButtonDark = Color(0xFF1A3C40)
    private val textSecondary = Color(0xFF515151)
    private val textSecondaryDark = Color(0xFF8D8D8D)
    private val button = Color(0xFF1A3C40)
    private val buttonDark = Color(0xFF1A3C40)
    private val buttonSecondary = Color(0xFFEEEEEE)
    private val buttonSecondaryDark = Color(0xFF252525)
    private val buttonInteractive = Color(0xFFEEEEEE)
    private val buttonInteractiveDark = Color(0x661A3C40)
    private val disabledText = Color(0xFF000000)
    private val disabledTextDark = Color(0xFFFFFFFF)
    private val disabledTextWithoutBg = Color(0xFF5D5D5D)
    private val disabledTextWithoutBgDark = Color(0xFFB1B1B1)
    private val activityIndicator = Color(0xFF1E185B)
    private val activityIndicatorDark = Color(0xFFFFFFFF)

    private val icon = Color(0xFF1D5C63)
    private val iconDark = Color(0xFFFFFFFF)
    private val iconSecondary = Color(0xFF1A3C40)
    private val iconSecondaryDark = Color(0xFF1A3C40)
    private val iconInteractive = Color(0xFF5D5D5D)
    private val iconInteractiveDark = Color(0xFF5D5D5D)
    private val border = Color(0xFFE3DFE6)
    private val borderDark = Color(0xFF252525)
    private val floated = Color(0xFF1A3C40)
    private val floatedDark = Color(0xFF1A3C40)

    private val error = Color(0xFFAC0303)
    private val gradientPrimary = listOf(button, appBar, background)
    private val gradientPrimaryDark = listOf(buttonDark, appBarDark, background)
    private val gradientSecondary = listOf(error, popUp, background)
    private val gradientSecondaryDark = listOf(button, appBar, background)
    private val gradientInteractive = listOf(button, error, textButton)
    private val gradientInteractiveDark = listOf(button, appBar, background)
    const val AlphaNearOpaque = 0.95f

    // Notify Theme Colors
    val NotifyLightColorPalette = NotifyColors(
        appBar = appBar,
        primary = button,
        secondary = button,
        uiBackground = background,
        popUp = popUp,
        textFieldBg = textFieldBg,
        cardBg = cardBg,
        title = title,
        button = button,
        buttonSecondary = buttonSecondary,
        buttonInteractive = buttonInteractive,
        activityIndicator = activityIndicator,
        border = border,
        floated = floated,
        textPrimary = textPrimary,
        textButton = textButton,
        textSecondary = textSecondary,
        textInteractive = disabledText,
        textInteractiveWithoutBg = disabledTextWithoutBg,
        icon = icon,
        iconSecondary = iconSecondary,
        iconInteractive = iconInteractive,
        error = error,
        gradientPrimary = gradientPrimary,
        gradientSecondary = gradientSecondary,
        gradientInteractive = gradientInteractive,
        isDark = false,
    )

    val NotifyDarkColorPalette = NotifyColors(
        appBar = appBarDark,
        primary = buttonDark,
        secondary = buttonDark,
        uiBackground = backgroundDark,
        popUp = popUpDark,
        textFieldBg = textFieldBgDark,
        cardBg = cardBgDark,
        title = titleDark,
        button = buttonDark,
        buttonSecondary = buttonSecondaryDark,
        buttonInteractive = buttonInteractiveDark,
        activityIndicator = activityIndicatorDark,
        border = borderDark,
        floated = floatedDark,
        textPrimary = textPrimaryDark,
        textButton = textButtonDark,
        textSecondary = textSecondaryDark,
        textInteractive = disabledTextDark,
        textInteractiveWithoutBg = disabledTextWithoutBgDark,
        icon = iconDark,
        iconSecondary = iconSecondaryDark,
        iconInteractive = iconInteractiveDark,
        error = error,
        gradientPrimary = gradientPrimaryDark,
        gradientSecondary = gradientSecondaryDark,
        gradientInteractive = gradientInteractiveDark,
        isDark = false,
    )


    // Native MaterialTheme Colors
    @SuppressLint("ConflictingOnColor")
    val LightColorPalette = lightColors(
        primary = appBar,
        primaryVariant = button,
        secondary = button,
        secondaryVariant = background,
        error = error,
        background = background,
        surface = appBar,
        onPrimary = appBar,

        onError = background,
        onSecondary = backgroundDark,
        onBackground = backgroundDark,
        onSurface = backgroundDark,
    )

    @SuppressLint("ConflictingOnColor")
    val DarkColorPalette = darkColors(
        primary = appBarDark,
        primaryVariant = buttonDark,
        secondary = buttonDark,
        secondaryVariant = buttonDark,
        error = error,
        background = backgroundDark,
        surface = backgroundDark,
        onPrimary = backgroundDark,

        onError = backgroundDark,
        onSecondary = background,
        onBackground = background,
        onSurface = background,
    )
}




