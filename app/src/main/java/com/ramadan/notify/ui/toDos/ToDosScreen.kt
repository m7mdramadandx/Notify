package com.ramadan.notify.ui.toDos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ramadan.notify.Application
import com.ramadan.notify.R
import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.ui.components.NotifyCard
import com.ramadan.notify.ui.toDos.components.OrderSection
import com.ramadan.notify.ui.toDos.components.ToDoItem
import com.ramadan.notify.utils.UiText
import com.ramadan.notify.utils.theme.NotifyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun ToDosScreen(
    modifier: Modifier = Modifier,
    modalBottomSheetState: ModalBottomSheetState,
    navController: NavController = rememberNavController(),
    viewModel: ToDosViewModel = hiltViewModel(),
) {

    val toDosState = viewModel.toDoState.value

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Column(modifier = modifier) {
        IconButton(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xxsmall)),
            onClick = { viewModel.onEvent(ToDosEvent.ToggleOrderSection) },
            content = {
                Icon(
                    imageVector = Icons.Default.Sort,
                    contentDescription = "",
                    tint = NotifyTheme.colors.icon,
                )
            },
        )

        AnimatedVisibility(
            visible = toDosState.isOrderSectionVisible,
            enter = slideInHorizontally(),
            exit = shrinkHorizontally(),
            content = {
                OrderSection(
                    toDoOrder = toDosState.toDoOrder,
                    onOrderChange = { viewModel.onEvent(ToDosEvent.Order(it)) }
                )
            }
        )

        LazyColumn {
            item {
                NotifyCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = dimensionResource(id = R.dimen.padding_medium),
                            end = dimensionResource(id = R.dimen.padding_medium),
                            top = dimensionResource(id = R.dimen.padding_xxsmall),
                            bottom = dimensionResource(id = R.dimen.padding_xxxlarge),
                        )
                        .clickable {
                            scope.launch {
                                modalBottomSheetState.apply {
                                    if (isVisible) hide() else show()
                                }
                            }
                        },
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(dimensionResource(id = R.dimen.padding_medium))
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.ic_add_item),
                        contentDescription = ""
                    )
                }

                toDosState.ToDos.forEachIndexed { index, toDo ->

                    ToDoItem(
                        modifier = Modifier.padding(bottom = if (index == toDosState.ToDos.lastIndex)
                            dimensionResource(id = R.dimen.padding_xlarge) else 0.dp),
                        toDo = toDo,
                        onMarkClick = { viewModel.onEvent(ToDosEvent.MarkToDo(toDo)) },
                        onDeleteClick = { onDeleteTodo(viewModel, scope, scaffoldState, toDo) },
                    )
                }
            }
        }
    }
}

private fun onDeleteTodo(
    viewModel: ToDosViewModel,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    toDo: ToDo,
) {
    viewModel.onEvent(ToDosEvent.DeleteToDo(toDo))
    scope.launch {
        val result =
            scaffoldState.snackbarHostState.showSnackbar(
                message = UiText.StringResource(R.string.todo_deleted)
                    .asString(Application.getAppContext()),
                actionLabel = UiText.StringResource(R.string.undo)
                    .asString(Application.getAppContext())
            )
        if (result == SnackbarResult.ActionPerformed) {
            viewModel.onEvent(ToDosEvent.RestoreToDo)
        }
    }
}