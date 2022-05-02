package ru.marslab.simplemovie.presentation.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SmallSpacer() {
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun MediumSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun BigSpacer() {
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
fun CustomVSpacer(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}
