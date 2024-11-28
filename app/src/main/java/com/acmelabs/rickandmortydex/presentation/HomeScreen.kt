package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.acmelabs.rickandmortydex.R
import com.acmelabs.rickandmortydex.domain.model.CharacterModel

@Composable
fun HomeScreen(
    resError: Int? = null,
    characters: List<CharacterModel>
) {
    var showError by remember { mutableStateOf(resError == null) }
    if (showError && resError != null) {
        AlertDialog(
            text = resError,
            title = R.string.error_dialog_title,
            onConfirmation = { showError = false },
            onDismissRequest = { showError = false }
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