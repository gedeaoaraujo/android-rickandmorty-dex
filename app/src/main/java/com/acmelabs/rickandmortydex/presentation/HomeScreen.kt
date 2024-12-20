package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.acmelabs.rickandmortydex.R

@Composable
fun HomeScreen(
    state: HomeScreenState,
    onAction: (HomeScreenActions) -> Unit = {}
) {
    if (state.resError != null) {
        AlertDialog(
            text = state.resError,
            title = R.string.error_dialog_title,
            onConfirmation = { onAction(HomeScreenActions.OnDialogTryAgain) }
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
                CharacterItem(item)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(HomeScreenState())
}