package ru.marslab.simplemovie.presentation.top250movies.model

import ru.marslab.simplemovie.core.Action

internal sealed class Top250MoviesAction : Action {
    data class ClickOnMovieCard(val movieId: String) : Top250MoviesAction()
}
