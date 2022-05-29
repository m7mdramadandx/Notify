package com.ramadan.notify.utils

import com.ramadan.notify.Application
import com.ramadan.notify.R

sealed class Screen(
    val route: String,
    val title: String = "",
    val icon: Int = R.drawable.ic_notepad,
) {
    object Note : Screen(
        route = "note",
        title = UiText.StringResource(R.string.note).asString(Application.getAppContext()),
        icon = R.drawable.ic_notepad
    )

    object ToDo : Screen(
        route = "todo",
        title = UiText.StringResource(R.string.todo).asString(Application.getAppContext()),
        icon = R.drawable.ic_checklist
    )

    object AddEditNote : Screen(route = "addEditNote")
}