package ru.marslab.simplemovie.presentation.moviedetail.model

data class MovieDetailState(
    val movie: MovieFullUi = MovieFullUi(
        id = "",
        title = "",
        description = "",
        rating = 0f,
        image = "",
        images = emptyList(),
        year = "",
        poster = "",
        runtime = "",
        release = "",
        genres = ""
    ),
    val isLoading: Boolean = false
)
