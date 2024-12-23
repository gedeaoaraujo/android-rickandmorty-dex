package com.acmelabs.rickandmortydex.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.acmelabs.rickandmortydex.R
import com.acmelabs.rickandmortydex.presentation.AlertDialog
import com.acmelabs.rickandmortydex.presentation.home.HomeScreenActions.OnDialogTryAgain
import org.koin.androidx.compose.koinViewModel

@Composable
fun RootHomeScreen(navController: NavHostController) {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsState()

    if (state.resError != null) {
        AlertDialog(
            text = state.resError!!,
            title = R.string.error_dialog_title,
            onConfirmation = { viewModel.onAction(OnDialogTryAgain) }
        )
    }
    if (state.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                fontSize = 24.sp,
                text = stringResource(R.string.carregando_dados)
            )
        }
        return
    }

    if (state.characters.isEmpty()) {
        HomeScreenEmptyList()
        return
    } else {
        LazyColumn {
            items(state.characters) { item ->
                CharacterItem(item) {
                    navController.navigate("details")
                }
            }
        }
    }
}
