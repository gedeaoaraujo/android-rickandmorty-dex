package com.acmelabs.rickandmortydex.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.acmelabs.rickandmortydex.R
import com.acmelabs.rickandmortydex.presentation.theme.RickAndMortyDexTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun RootDetailsScreen(characterId: Int) {
    val viewModel = koinViewModel<DetailsViewModel>()
    viewModel.loadSelectedCharacter(characterId)
    val charLoc by viewModel.charLoc.collectAsState(null)
    RickAndMortyDexTheme {
        Box(Modifier.fillMaxSize()) {
            Column(Modifier.fillMaxSize()) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = character?.imageUrl.orEmpty(),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = character?.name.orEmpty(),
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
                Text(text = "Name: ${character?.name}", Modifier.padding(8.dp))
                Text(text = "Origin: ${character?.origin}", Modifier.padding(8.dp))
                Text(text = "Status: ${character?.status}", Modifier.padding(8.dp))
                Text(text = "Species: ${character?.species}", Modifier.padding(8.dp))
            }
        }
    }
}