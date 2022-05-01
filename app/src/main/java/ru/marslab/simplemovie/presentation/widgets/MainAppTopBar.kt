package ru.marslab.simplemovie.presentation.widgets

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun MainAppTopBar(@StringRes stringId: Int) {
    TopAppBar() {
        Text(text = stringResource(id = stringId), style = MaterialTheme.typography.h4)
    }
}
