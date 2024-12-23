package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.acmelabs.rickandmortydex.presentation.details.DetailsScreen
import com.acmelabs.rickandmortydex.presentation.home.RootHomeScreen
import com.acmelabs.rickandmortydex.presentation.theme.RickAndMortyDexTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RootApp() {
    RickAndMortyDexTheme {
        Scaffold(
            modifier = Modifier.padding(WindowInsets.statusBars.asPaddingValues()),
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(text = "Rick & Morty") },
                    colors = TopAppBarDefaults.topAppBarColors().copy(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { innerPadding ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "home") {
                    composable("home") { RootHomeScreen(navController) }
                    composable("details") { DetailsScreen() }
                }
            }
        }
    }
}