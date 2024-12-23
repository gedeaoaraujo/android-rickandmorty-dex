package com.acmelabs.rickandmortydex.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun RootHomeScreen(navController: NavHostController) {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsState()
    HomeScreen(state, viewModel::onAction, navController)
}
