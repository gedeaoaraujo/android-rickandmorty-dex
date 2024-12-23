package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.acmelabs.rickandmortydex.presentation.theme.RickAndMortyDexTheme

@Composable
fun DetailsScreen() {
    RickAndMortyDexTheme {
        Box(Modifier.fillMaxSize()) {
            Text(text = "Detalhes")
        }
    }
}