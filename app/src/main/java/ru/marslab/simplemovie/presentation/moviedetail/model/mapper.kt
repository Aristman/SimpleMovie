package ru.marslab.simplemovie.presentation.moviedetail.model

import ru.marslab.samplemovie.shared.domain.entity.Movie

fun Movie.toFullUi(): MovieFullUi =
    MovieFullUi(
        id = id,
        title = title,
        description = description,
        rating = rating,
        image = image,
        images = images,
        year = year
    )
