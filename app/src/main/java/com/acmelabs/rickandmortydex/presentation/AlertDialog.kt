package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun AlertDialog(
    text: Int,
    title: Int,
    onConfirmation: ()->Unit = {},
    onDismissRequest: (()->Unit)? = null,
) {
    AlertDialog(
        title = { Text(text = stringResource(id = title)) },
        text = { Text(text = stringResource(id = text)) },
        confirmButton = {
            TextButton(onClick = onConfirmation) { Text("Tentar novamente") }
        },
        dismissButton = { if (onDismissRequest != null) {
            TextButton(onClick = onDismissRequest) { Text("Cancelar") }
        }},
        onDismissRequest = {},
        modifier = Modifier.fillMaxWidth()
    )
}