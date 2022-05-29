package com.ramadan.notify.ui.add_edit_note

import androidx.compose.animation.Animatable
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector4D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
//import androidx.compose.material.icons.rounded.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ramadan.notify.R
import com.ramadan.notify.domain.model.Note
import com.ramadan.notify.ui.components.MyTextField
import com.ramadan.notify.ui.components.NotifyAppBar
import com.ramadan.notify.ui.components.NotifyScaffold
import com.ramadan.notify.utils.UiText
import com.ramadan.notify.ui.theme.NotifyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun AddEditNoteScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    noteColor: Int,
    viewModel: AddEditNoteViewModel = hiltViewModel(),
) {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value

    val noteBackgroundAnimatable = remember {
        Animatable(
            Color(if (noteColor != -1) noteColor else viewModel.noteColor.value)
        )
    }

    LaunchedEffect(key1 = true) {

        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is AddEditNoteViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AddEditNoteViewModel.UiEvent.SaveNote -> {
                    navController.navigateUp()
                }
            }
        }
    }

    NotifyScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            NotifyAppBar(
                title = UiText.StringResource(R.string.app_name).asString(),
                backgroundColor = noteBackgroundAnimatable.value,
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            tint = NotifyTheme.colors.icon,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onEvent(AddEditNoteEvent.SaveNote) },
                backgroundColor = NotifyTheme.colors.popUp
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = "",
                    tint = NotifyTheme.colors.icon
                )
            }
        },
    ) {
        val focusManager = LocalFocusManager.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(noteBackgroundAnimatable.value)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    Note.noteColors.forEach { color ->
                        ColorPicker(viewModel, scope, color, noteBackgroundAnimatable)
                    }
                }
            )

            // note title
            MyTextField(
                value = titleState.text,
                label = titleState.hint,
                background = Color.Transparent,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                },
                singleLine = true,
                keyboardActions = { focusManager.moveFocus(FocusDirection.Next) },
                textStyle = NotifyTheme.typography.titleMedium
            )

            // note content
            MyTextField(
                modifier = Modifier.fillMaxHeight(),
                value = contentState.text,
                label = contentState.hint,
                background = Color.Transparent,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                },
                keyboardActions = { focusManager.clearFocus() },
                textStyle = MaterialTheme.typography.body1,
            )
        }
    }
}

@Composable
private fun ColorPicker(
    viewModel: AddEditNoteViewModel,
    scope: CoroutineScope,
    color: Color,
    noteBackgroundAnimatable: Animatable<Color, AnimationVector4D>,
) {
    val colorInt = color.toArgb()

    Box(
        modifier = Modifier
            .size(50.dp)
            .shadow(15.dp, CircleShape)
            .clip(CircleShape)
            .background(color)
            .border(
                width = 2.dp,
                color = if (viewModel.noteColor.value == colorInt) Color.DarkGray
                else Color.Transparent,
                shape = CircleShape
            )
            .clickable {
                scope.launch {
                    noteBackgroundAnimatable.animateTo(
                        targetValue = Color(colorInt),
                        animationSpec = tween(durationMillis = 500)
                    )
                }
                viewModel.onEvent(AddEditNoteEvent.ChangeColor(colorInt))
            }
    )
}

@ExperimentalAnimationApi
@Preview
@Composable
fun ColorPickerPreview() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        horizontalArrangement = Arrangement.SpaceBetween,
        content = {
            Note.noteColors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .shadow(15.dp, CircleShape)
                        .clip(CircleShape)
                        .background(color)
                        .border(
                            width = 2.dp,
                            color = Color.DarkGray,
                            shape = CircleShape
                        )
                        .clickable {}
                )
            }
        }
    )

}