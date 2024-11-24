package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.acmelabs.rickandmortydex.domain.model.CharacterModel

@Composable
fun HomeScreen(
    characters: List<CharacterModel>
) {
    LazyColumn {
        items(characters){ item ->
            Text(text = item.name)

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(emptyList())
}