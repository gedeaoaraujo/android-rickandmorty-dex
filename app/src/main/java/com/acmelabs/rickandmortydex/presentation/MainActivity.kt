package com.acmelabs.rickandmortydex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.acmelabs.rickandmortydex.presentation.details.DetailsScreen
import com.acmelabs.rickandmortydex.presentation.home.RootHomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "home") {
                composable("home") { RootHomeScreen(navController) }
                composable("details") { DetailsScreen() }
            }
        }
    }
}