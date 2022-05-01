package ru.marslab.simplemovie.presentation.top250movies.model

import ru.marslab.samplemovie.shared.domain.entity.Movie

fun Movie.toShortUi(): MovieShortUi =
    MovieShortUi(
        id = id,
        title = title,
        rating = kotlin.runCatching { rating.toFloat() / 10f }.getOrDefault(0f),
        ratingString = rating,
        year = year,
        image = image
    )
