package com.acmelabs.rickandmortydex.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.acmelabs.rickandmortydex.R
import com.acmelabs.rickandmortydex.domain.model.CharacterModel

@Composable
fun CharacterItem(item: CharacterModel, onSelectItem: () -> Unit = {}) {
    Card(Modifier.padding(4.dp).clickable(onClick = onSelectItem)) {
        Row(modifier = Modifier.fillMaxHeight().background(MaterialTheme.colorScheme.secondary)) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.name,
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.size(100.dp, 140.dp)
            )
            Column(Modifier.padding(16.dp).fillMaxWidth()) {
                Text(text = item.name, color = MaterialTheme.colorScheme.onPrimary)
                Spacer(modifier = Modifier.height(6.dp))
                Row {
                    Text("${item.status} - ", color = MaterialTheme.colorScheme.onPrimary)
                    Text(item.species, color = MaterialTheme.colorScheme.onPrimary)
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Last known location:", color = MaterialTheme.colorScheme.onPrimary)
                Text(text = item.origin?:"Unknown", color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}

@Preview
@Composable
private fun CharacterItemPreview(){
    val item = CharacterModel(
        id = 1,
        name = "Name",
        status = "Alive",
        species = "Human",
        origin = "Origin",
        imageUrl = "https://"
    )
    CharacterItem(item = item)
}
