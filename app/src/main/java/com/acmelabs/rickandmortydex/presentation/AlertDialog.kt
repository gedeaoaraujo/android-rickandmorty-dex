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
    onConfirmation: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
) {
    AlertDialog(
        title = { Text(text = stringResource(id = title)) },
        text = { Text(text = stringResource(id = text)) },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(onClick = { onConfirmation() }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text("Dismiss")
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}