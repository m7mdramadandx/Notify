package com.ramadan.notify.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ramadan.notify.ui.theme.NotifyTheme

@Composable
fun NotifyAppBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = NotifyTheme.colors.appBar,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = 8.dp,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = NotifyTheme.colors.title
            )
        },
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation
    )

}