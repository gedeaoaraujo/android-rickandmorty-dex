package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.acmelabs.rickandmortydex.R
import com.acmelabs.rickandmortydex.domain.model.CharacterModel

@Composable
fun HomeScreen(
    resError: Int? = null,
    characters: List<CharacterModel>,
    onTryAgain: (() -> Unit)? = {}
) {
    if (resError != null) {
        AlertDialog(
            text = resError,
            title = R.string.error_dialog_title,
            onConfirmation = { onTryAgain?.invoke() }
        )
    } else {
        LazyColumn {
            items(characters) { item ->
                CharacterItem(item)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(characters = emptyList())
}