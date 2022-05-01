package ru.marslab.simplemovie.presentation.top250movies.model

data class MovieShortUi(
    val id: String,
    val title: String,
    val rating: Float,
    val ratingString: String,
    val year: String,
    val image: String
)
