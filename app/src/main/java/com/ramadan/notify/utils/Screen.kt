package com.ramadan.notify.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StickyNote2
import androidx.compose.material.icons.rounded.Task
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramadan.notify.Application
import com.ramadan.notify.R

sealed class Screen(
    val route: String,
    val title: String = "",
    val icon: ImageVector = Icons.Rounded.StickyNote2,
) {
    object Note : Screen(
        route = "note",
        title = UiText.StringResource(R.string.note).asString(Application.getAppContext()),
        icon = Icons.Rounded.StickyNote2
    )

    object ToDo : Screen(
        route = "todo",
        title = UiText.StringResource(R.string.todo).asString(Application.getAppContext()),
        icon = Icons.Rounded.Task
    )

    object AddEditNote : Screen(route = "addEditNote")
}