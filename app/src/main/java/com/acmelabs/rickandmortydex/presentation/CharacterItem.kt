package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acmelabs.rickandmortydex.domain.model.CharacterModel

@Composable
fun CharacterItem(item: CharacterModel) {
    Card(Modifier.padding(8.dp)) {
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = item.name, color = MaterialTheme.colorScheme.onPrimary)
            Spacer(modifier = Modifier.height(6.dp))
            Row {
                Text("${item.status} - ", color = MaterialTheme.colorScheme.onPrimary)
                Text(item.species, color = MaterialTheme.colorScheme.onPrimary)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Last known location:", color = MaterialTheme.colorScheme.onPrimary)
            Text(text = item.origin, color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}
