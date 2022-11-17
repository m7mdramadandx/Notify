package com.ramadan.notify.utils

import com.ramadan.notify.Application
import com.ramadan.notify.R

sealed class NotifyScreen(
    val route: String,
    val title: String = "",
    val icon: Int = R.drawable.ic_notepad,
) {
    object Note : NotifyScreen(
        route = "note",
        title = UiText.StringResource(R.string.note).asString(Application.getAppContext()),
        icon = R.drawable.ic_notepad
    )

    object ToDo : NotifyScreen(
        route = "todo",
        title = UiText.StringResource(R.string.todo).asString(Application.getAppContext()),
        icon = R.drawable.ic_checklist
    )

    object Test : NotifyScreen(
        route = "test",
        title = "Test",
        icon = R.drawable.ic_delete
    )

    object AddEditNote : NotifyScreen(route = "addEditNote")
}