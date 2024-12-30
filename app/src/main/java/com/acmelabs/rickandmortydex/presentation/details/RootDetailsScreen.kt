package com.acmelabs.rickandmortydex.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.acmelabs.rickandmortydex.presentation.theme.RickAndMortyDexTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun RootDetailsScreen(characterId: Int) {
    val viewModel = koinViewModel<DetailsViewModel>()
    viewModel.loadSelectedCharacter(characterId)
    val character by viewModel.character.collectAsState(null)
    RickAndMortyDexTheme {
        Box(Modifier.fillMaxSize()) {
            Text(text = "characterId: ${character?.id}")
        }
    }
}