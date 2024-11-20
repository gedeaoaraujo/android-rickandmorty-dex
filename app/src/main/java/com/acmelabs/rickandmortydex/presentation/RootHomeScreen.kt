package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.acmelabs.rickandmortydex.ui.theme.RickAndMortyDexTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootHomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val characters by viewModel.characters.collectAsState()
    RickAndMortyDexTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = "Rick & Morty",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                })
            },
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                HomeScreen(characters)
            }
        }
    }
}