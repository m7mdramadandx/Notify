package com.ramadan.notify.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.insets.ProvideWindowInsets
import com.ramadan.notify.R
import com.ramadan.notify.ui.add_edit_note.AddEditNoteScreen
import com.ramadan.notify.ui.components.*
import com.ramadan.notify.ui.notes.NotesScreen
import com.ramadan.notify.ui.toDos.ToDosEvent
import com.ramadan.notify.ui.toDos.ToDosScreen
import com.ramadan.notify.ui.toDos.ToDosViewModel
import com.ramadan.notify.utils.Constant
import com.ramadan.notify.utils.InAppUpdate
import com.ramadan.notify.utils.Screen
import com.ramadan.notify.utils.UiText
import com.ramadan.notify.ui.theme.AppTheme
import com.ramadan.notify.ui.theme.NotifyShape
import com.ramadan.notify.ui.theme.NotifyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private var inAppUpdate: InAppUpdate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inAppUpdate = InAppUpdate(this)

        setContent {
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            val scaffoldState = rememberScaffoldState()
            val modalBottomSheetState =
                rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

            AppTheme {
                ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                    ModalBottomSheetLayout(
                        sheetState = modalBottomSheetState,
                        sheetShape = NotifyShape.bottomSheetShape,
                        sheetBackgroundColor = NotifyTheme.colors.background,
                        sheetContent = {
                            ModalBottomSheetContent(modalBottomSheetState, scaffoldState)
                        }
                    ) {
                        NotifyScaffold(
                            scaffoldState = scaffoldState,
                            topBar = { MyTopBar(navController) },
                            bottomBar = { MyBottomBar(navController) },
                        ) { innerPadding ->
                            NavigationGraph(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                scaffoldState = scaffoldState,
                                modalBottomSheetState = modalBottomSheetState
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ModalBottomSheetContent(
        modalBottomSheetState: ModalBottomSheetState,
        scaffoldState: ScaffoldState,
        viewModel: ToDosViewModel = hiltViewModel(),
    ) {
        val focusManager = LocalFocusManager.current
        val scope = rememberCoroutineScope()

        Box(modifier = Modifier.padding(vertical = 24.dp, horizontal = 24.dp)) {

            Column {
                Text(
                    text = UiText.StringResource(R.string.new_todo).asString(),
                    fontSize = 28.sp,
                    color = NotifyTheme.colors.onSurface
                )

                Spacer(Modifier.padding(top = 24.dp))
                NotifyTextField(
                    text = viewModel.toDoTitle.value,
                    hint = UiText.StringResource(R.string.enter_todo_title).asString(),
                    onValueChange = { viewModel.toDoTitle.value = it },
                )

                Spacer(Modifier.padding(top = dimensionResource(id = R.dimen.padding_xxxlarge)))
                MyButton(
                    onClick = {
                        viewModel.onEvent(ToDosEvent.SaveToDo)
                        scope.launch {
                            modalBottomSheetState.hide()
                            focusManager.clearFocus()
                        }
                    },
                    buttonText = UiText.StringResource(R.string.save).asString()
                )
            }
        }

    }

    @Composable
    fun NavigationGraph(
        modifier: Modifier = Modifier,
        navController: NavHostController,
        scaffoldState: ScaffoldState,
        modalBottomSheetState: ModalBottomSheetState,
    ) {
        NavHost(navController, startDestination = Screen.Note.route) {
            composable(Screen.Note.route) {
                NotesScreen(
                    modifier = modifier,
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
            composable(
                route = Screen.AddEditNote.route + "?noteId={noteId}&noteColor={noteColor}",
                arguments = listOf(
                    navArgument(
                        name = "noteId",
                        builder = {
                            type = NavType.IntType
                            defaultValue = -1
                        }
                    ),
                    navArgument(
                        name = "noteColor",
                        builder = {
                            type = NavType.IntType
                            defaultValue = -1
                        }
                    ),
                ),
            ) {
                val color = it.arguments?.getInt("noteColor") ?: -1
                AddEditNoteScreen(
                    modifier = modifier,
                    navController = navController,
                    noteColor = color
                )
            }
            composable(Screen.ToDo.route) {
                ToDosScreen(
                    modifier = modifier,
                    navController = navController,
                    modalBottomSheetState = modalBottomSheetState
                )
            }

        }
    }

    @Composable
    fun MyTopBar(navController: NavController) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        if (currentRoute?.contains(Screen.AddEditNote.route) == false) {
            NotifyAppBar(
                title = stringResource(R.string.app_name),
            )
        }
    }


    @Composable
    fun MyBottomBar(navController: NavController) {
        val items = listOf(Screen.Note, Screen.ToDo)
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        AnimatedVisibility(
            visible = (currentRoute == Screen.Note.route) || (currentRoute == Screen.ToDo.route),
            enter = expandVertically(),
            exit = shrinkVertically(),
        ) {

            var selectedIndex by remember { mutableStateOf(0) }
            var previousIndex by remember { mutableStateOf(0) }

            onBackPressedDispatcher.addCallback {
                navController.previousBackStackEntry?.let {
                    selectedIndex = previousIndex
                    navController.popBackStack()
                } ?: run {
                    Log.i(Constant.DEBUG_TAG, "000")
                }
            }

            BottomNavigation(backgroundColor = NotifyTheme.colors.background) {
                NotifySurface {
                    Divider()
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = dimensionResource(id = R.dimen.padding_medium))
                            .height(24.dp.times(1.5f))
                    ) {
                        for ((index, screen) in items.withIndex()) {
                            AnimatableIcon(
                                imageVector = screen.icon,
                                scale = if (selectedIndex == index) 1.5f else 1.0f,
                                color = if (selectedIndex == index) NotifyTheme.colors.primary else NotifyTheme.colors.outline,
                                iconSize = 24.dp,
                            ) {
                                if (selectedIndex != index) {
                                    previousIndex = selectedIndex
                                    selectedIndex = index
                                    navController.navigate(screen.route) {
                                        navController.graph.startDestinationRoute?.let { screen_route ->
                                            popUpTo(screen_route) {
                                                saveState = true
                                            }
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun AnimatableIcon(
        imageVector: Int,
        modifier: Modifier = Modifier,
        iconSize: Dp = 24.dp,
        scale: Float = 1f,
        color: Color = NotifyTheme.colors.primary,
        onClick: () -> Unit,
    ) {
        // Animation params
        val animatedScale: Float by animateFloatAsState(
            targetValue = scale,
            // Here the animation spec serves no purpose but to demonstrate in slow speed.
            animationSpec = TweenSpec(
                durationMillis = 2000,
                easing = FastOutSlowInEasing
            )
        )
        val animatedColor by animateColorAsState(
            targetValue = color,
            animationSpec = TweenSpec(
                durationMillis = 2000,
                easing = FastOutSlowInEasing
            )
        )

        IconButton(
            onClick = onClick,
            modifier = modifier.size(iconSize)
        ) {
            Image(
                painter = painterResource(id = imageVector),
                contentDescription = "",
                colorFilter = ColorFilter.tint(animatedColor),
                modifier = modifier.scale(animatedScale)
            )
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        inAppUpdate?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onResume() {
        super.onResume()
        inAppUpdate?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        inAppUpdate?.onDestroy()
    }
}