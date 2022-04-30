package ru.marslab.samplemovie.shared.data.db

import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.shared.database.Top250MoviesDbEntity

fun Top250MoviesDbEntity.toDomain(): Movie =
    Movie(
        id = id,
        title = title,
        description = description,
        rating = rating,
        image = image,
        year = year
    )

internal fun Movie.toDb(): Top250MoviesDbEntity =
    Top250MoviesDbEntity(
        id = id,
        title = title,
        description = description,
        rating = rating,
        image = image,
        year = year
    )
