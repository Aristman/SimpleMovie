package ru.marslab.simplemovie.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RatingRoundWidget(rating: Float) {
    val color = Color(red = 1 - rating, green = rating, blue = 0f)
    Box(modifier = Modifier.size(32.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(50))
                .size(32.dp)
                .background(color = Color.DarkGray),
            strokeWidth = 2.dp,
            color = color,
            progress = rating
        )
        Text(
            text = (rating * 100).toInt().toString(),
            color = color,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.body2,
        )
    }
}
