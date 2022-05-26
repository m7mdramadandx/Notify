package com.ramadan.notify.ui.notes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ramadan.notify.R
import com.ramadan.notify.domain.model.Note
import com.ramadan.notify.ui.notes.components.NoteItem
import com.ramadan.notify.ui.notes.components.NoteItemLayout
import com.ramadan.notify.ui.notes.components.OrderSection
import com.ramadan.notify.utils.Screen
import com.ramadan.notify.utils.StaggeredVerticalGrid
import com.ramadan.notify.utils.theme.NotifyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: NotesViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState,
) {
    val notesState = viewModel.notesState.value
    val scope = rememberCoroutineScope()

    Column(modifier = modifier) {
        IconButton(
            onClick = { viewModel.onEvent(NotesEvent.ToggleOrderSection) },
            content = {
                Icon(
                    imageVector = Icons.Rounded.Sort,
                    contentDescription = "",
                    tint = NotifyTheme.colors.icon,
                )
            },
        )
        AnimatedVisibility(
            visible = notesState.isOrderSectionVisible,
            enter = slideInHorizontally(),
            exit = shrinkHorizontally(),
            content = {
                OrderSection(
                    noteOrder = notesState.noteOrder,
                    onOrderChange = { viewModel.onEvent(NotesEvent.Order(it)) }
                )
            }
        )
        LazyColumn {
            item {
                StaggeredVerticalGrid {
                    // Add New Item
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.padding_xxsmall))
                        .clickable { navController.navigate(Screen.AddEditNote.route) }) {

                        NoteItemLayout(
                            modifier = Modifier.matchParentSize(),
                            noteColor = Note.noteColors.first().toArgb()
                        )

                        Icon(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(dimensionResource(id = R.dimen.padding_xxxlarge))
                                .size(54.dp),
                            painter = painterResource(id = R.drawable.ic_add_item),
                            contentDescription = "Add"
                        )
                    }

                    notesState.notes.forEachIndexed { index, note ->
                        NoteItem(
                            modifier = Modifier
//                                .padding(bottom = if (index == notesState.notes.lastIndex)
//                                    dimensionResource(id = R.dimen.padding_xlarge) else 0.dp)
                                .clickable {
                                    navController.navigate(
                                        Screen.AddEditNote.route + "?noteId=${note.id}&noteColor=${note.color}"
                                    )
                                },
                            note = note,
                            onDeleteClick = {
                                onDeleteNote(viewModel, scope, scaffoldState, note)
                            }
                        )
                    }
                }

            }
        }
    }
}

private fun onDeleteNote(
    viewModel: NotesViewModel,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    note: Note,
) {
    viewModel.onEvent(NotesEvent.DeleteNote(note))
    scope.launch {
        val result =
            scaffoldState.snackbarHostState.showSnackbar(
                message = "Note deleted",
                actionLabel = "Undo"
            )
        if (result == SnackbarResult.ActionPerformed) {
            viewModel.onEvent(NotesEvent.RestoreNote)
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun StaggeredVerticalGridPreview() {

    val list = mutableListOf(Note.defaultNote,
        Note.defaultNote,
        Note.defaultNote2,
        Note.defaultNote,
        Note.defaultNote)

    LazyColumn {
        item {
            StaggeredVerticalGrid {
                list.forEach {
                    NoteItem(note = it, onDeleteClick = {})
                }
            }
        }

    }
}