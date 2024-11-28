package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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