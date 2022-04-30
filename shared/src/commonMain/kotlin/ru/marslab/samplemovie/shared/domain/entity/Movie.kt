package ru.marslab.samplemovie.shared.domain.entity

data class Movie(
    val id: String,
    val title: String,
    val description: String,
    val rating: Float,
    val image: String,
    val year: String
)
