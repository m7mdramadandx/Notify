package com.ramadan.notify.ui.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@ExperimentalMaterialApi
@Composable
fun TestScreen(
    modalBottomSheetState: ModalBottomSheetState,
    navController: NavController = rememberNavController(),
    viewModel: TestViewModel = hiltViewModel(),
) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(modifier = Modifier) {

    }

}