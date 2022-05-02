package ru.marslab.simplemovie.presentation.moviedetail.model

import ru.marslab.samplemovie.shared.domain.entity.Movie

fun Movie.toFullUi(): MovieFullUi =
    MovieFullUi(
        id = id,
        title = title,
        description = description,
        rating = kotlin.runCatching { rating.toFloat() / 10f }.getOrDefault(0f),
        image = image,
        images = images,
        year = year,
        release = release,
        runtime = runtime,
        poster = poster,
        genres = genres
    )
