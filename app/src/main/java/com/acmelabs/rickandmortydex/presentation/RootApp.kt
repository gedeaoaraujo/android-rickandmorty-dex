package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.acmelabs.rickandmortydex.presentation.details.RootDetailsScreen
import com.acmelabs.rickandmortydex.presentation.home.RootHomeScreen
import com.acmelabs.rickandmortydex.presentation.theme.RickAndMortyDexTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RootApp() {
    RickAndMortyDexTheme {
        Scaffold(
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
                NavHost(navController, startDestination = Route.HOME) {
                    composable(Route.HOME) {
                        RootHomeScreen(navController)
                    }
                    composable("${Route.DETAILS}/{id}") { backStackEntry ->
                        val characterId = backStackEntry.arguments?.getString("id")
                        RootDetailsScreen(characterId?.toInt() ?: 0)
                    }
                }
            }
        }
    }
}