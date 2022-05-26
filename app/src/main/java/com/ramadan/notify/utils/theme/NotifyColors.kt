package com.ramadan.notify.utils.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class NotifyColors(
    appBar: Color,
    primary: Color,
    secondary: Color,
    uiBackground: Color,
    popUp: Color,
    textFieldBg: Color,
    cardBg: Color,
    title: Color,
    button: Color,
    buttonSecondary: Color,
    buttonInteractive: Color,
    activityIndicator: Color,
    border: Color,
    floated: Color,
    textPrimary: Color,
    textButton: Color,
    textSecondary: Color,
    textInteractive: Color,
    textInteractiveWithoutBg: Color,
    icon: Color,
    iconSecondary: Color,
    iconInteractive: Color,
    error: Color,
    isDark: Boolean,
    gradientPrimary: List<Color>,
    gradientSecondary: List<Color>,
    gradientInteractive: List<Color>,
) {

    var appBar by mutableStateOf(appBar)
        private set
    var primary by mutableStateOf(primary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var background by mutableStateOf(uiBackground)
        private set
    var popUp by mutableStateOf(popUp)
        private set
    var textFieldBg by mutableStateOf(textFieldBg)
        private set
    var cardBg by mutableStateOf(cardBg)
        private set
    var activityIndicator by mutableStateOf(activityIndicator)
        private set
    var title by mutableStateOf(title)
        private set
    var button by mutableStateOf(button)
        private set
    var buttonSecondary by mutableStateOf(buttonSecondary)
        private set
    var buttonInteractive by mutableStateOf(buttonInteractive)
        private set
    var border by mutableStateOf(border)
        private set
    var floated by mutableStateOf(floated)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textButton by mutableStateOf(textButton)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textInteractive by mutableStateOf(textInteractive)
        private set
    var textInteractiveWithoutBg by mutableStateOf(textInteractiveWithoutBg)
        private set
    var icon by mutableStateOf(icon)
        private set
    var iconSecondary by mutableStateOf(iconSecondary)
        private set
    var iconInteractive by mutableStateOf(iconInteractive)
        private set
    var error by mutableStateOf(error)
        private set
    var isDark by mutableStateOf(isDark)
        private set
    var gradientPrimary by mutableStateOf(gradientPrimary)
        private set
    var gradientSecondary by mutableStateOf(gradientSecondary)
        private set
    var gradientInteractive by mutableStateOf(gradientInteractive)
        private set

    fun update(other: NotifyColors) {
        appBar = other.appBar
        primary = other.primary
        secondary = other.secondary
        background = other.background
        popUp = other.popUp
        textFieldBg = other.textFieldBg
        cardBg = other.cardBg
        title = other.title
        button = other.button
        buttonSecondary = other.buttonSecondary
        buttonInteractive = other.buttonInteractive
        activityIndicator = other.activityIndicator
        border = other.border
        floated = other.floated
        textPrimary = other.textPrimary
        textButton = other.textButton
        textSecondary = other.textSecondary
        textInteractive = other.textInteractive
        textInteractiveWithoutBg = other.textInteractiveWithoutBg
        icon = other.icon
        iconSecondary = other.iconSecondary
        iconInteractive = other.iconInteractive
        error = other.error
        isDark = other.isDark
    }

    fun copy(): NotifyColors = NotifyColors(
        appBar = appBar,
        primary = primary,
        secondary = secondary,
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
        textInteractive = textInteractive,
        textInteractiveWithoutBg = textInteractiveWithoutBg,
        icon = icon,
        iconSecondary = iconSecondary,
        iconInteractive = iconInteractive,
        error = error,
        isDark = isDark,
        gradientPrimary = gradientPrimary,
        gradientSecondary = gradientSecondary,
        gradientInteractive = gradientInteractive,
    )
}