package ru.marslab.simplemovie.presentation.moviedetail.model

import ru.marslab.samplemovie.shared.domain.entity.Image

data class MovieFullUi(
    val id: String,
    val title: String,
    val description: String,
    val rating: Float,
    val image: String,
    val images: List<Image>,
    val year: String,
    val release: String,
    val runtime: String,
    val poster: String,
    val genres: String
)
