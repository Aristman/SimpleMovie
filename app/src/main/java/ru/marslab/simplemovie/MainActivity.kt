package ru.marslab.simplemovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import ru.marslab.simplemovie.presentation.theme.SimpleMovieTheme
import ru.marslab.simplemovie.presentation.top250movies.Top250MoviesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleMovieTheme {
                Navigator(screen = Top250MoviesScreen())
            }
        }
    }
}
