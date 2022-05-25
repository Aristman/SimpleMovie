package ru.marslab.simplemovie.presentation.moviedetail.model

import ru.marslab.simplemovie.core.Action

sealed class MovieDetailAction : Action {
    data class LoadMovieInfo(val movieId: String, val fromNetwork: Boolean = false) :
        MovieDetailAction()
}
