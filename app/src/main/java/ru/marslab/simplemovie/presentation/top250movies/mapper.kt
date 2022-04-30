package ru.marslab.simplemovie.presentation.top250movies

import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.presentation.top250movies.model.MovieShortUi

fun Movie.toShortUi(): MovieShortUi =
    MovieShortUi(
        id = id,
        title = title,
        rating = rating,
        year = year,
        image = image
    )
