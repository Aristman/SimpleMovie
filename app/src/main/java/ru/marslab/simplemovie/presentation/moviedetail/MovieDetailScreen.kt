package ru.marslab.simplemovie.presentation.moviedetail

import android.util.Log
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen

class MovieDetailScreen(private val movieId: String) : AndroidScreen() {

    @Composable
    override fun Content() {
        Log.d("TAG", "Content: $movieId")
    }
}
