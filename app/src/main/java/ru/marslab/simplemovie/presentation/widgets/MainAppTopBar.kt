package ru.marslab.simplemovie.presentation.widgets

import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import ru.marslab.simplemovie.R

@Composable
fun MainAppTopBar(@StringRes stringId: Int) {
    MainAppTopBar(text = stringResource(id = stringId))
}

@Composable
fun MainAppTopBar(
    text: String,
    style: TextStyle = MaterialTheme.typography.h4,
    backIcon: Boolean = false,
    refreshIcon: Boolean = false,
    onBackClick: (() -> Unit) = {},
    onRefreshClick: (() -> Unit) = {}
) {
    TopAppBar(
        title = { Text(text = text, style = style) },
        navigationIcon = {
            if (backIcon) {
                IconButton(
                    onClick = onBackClick
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                        contentDescription = null,
                    )
                }
            }
        },
        actions = {
            if (refreshIcon) {
                IconButton(onClick = onRefreshClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_refresh_24),
                        contentDescription = null
                    )
                }
            }
        }
    )
}
