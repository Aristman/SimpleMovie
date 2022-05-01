package ru.marslab.simplemovie.presentation.moviedetail.model

data class MovieDetailState(
    val movie: MovieFullUi = MovieFullUi(
        id = "",
        title = "",
        description = "",
        rating = "",
        image = "",
        images = emptyList(),
        year = ""
    ),
    val isLoading: Boolean = false
)
