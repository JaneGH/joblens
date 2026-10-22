package com.itclimb.joblens.ui.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Profile",
        style = MaterialTheme.typography.headlineSmall,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    )
}
