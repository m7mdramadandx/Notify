package com.ramadan.notify.utils

import androidx.compose.runtime.Composable
import com.ramadan.notify.ui.components.NotifySurface
import com.ramadan.notify.ui.theme.AppTheme

@Composable
internal fun ThemedPreview(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    AppTheme(darkTheme = darkTheme) {
        NotifySurface {
            content()
        }
    }
}
