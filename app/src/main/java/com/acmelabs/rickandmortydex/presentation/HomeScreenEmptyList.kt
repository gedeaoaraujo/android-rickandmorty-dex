package com.acmelabs.rickandmortydex.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acmelabs.rickandmortydex.R

@Composable
fun HomeScreenEmptyList() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.wifi_off_24)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                text = stringResource(R.string.list_is_empty)
            )
        }
    }
}