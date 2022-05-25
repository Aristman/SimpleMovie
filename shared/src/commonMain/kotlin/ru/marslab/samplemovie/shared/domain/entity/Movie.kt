package ru.marslab.samplemovie.shared.domain.entity

data class Movie(
    val id: String,
    val title: String,
    val description: String,
    val rating: String,
    val image: String,
    val images: List<Image>,
    val year: String,
    val release: String,
    val runtime: String,
    val poster: String,
    val genres: String
)
