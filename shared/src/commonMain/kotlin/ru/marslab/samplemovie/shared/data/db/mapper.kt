package ru.marslab.samplemovie.shared.data.db

import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.shared.database.Movies
import ru.marslab.simplemovie.shared.database.Top250MoviesDbEntity

private const val ITEM_SEPARATOR = '~'
private const val OBJECT_SEPARATOR = '|'

fun Top250MoviesDbEntity.toDomain(): Movie =
    Movie(
        id = id,
        title = title,
        description = description,
        rating = rating,
        image = image,
        images = emptyList(),
        year = year
    )

internal fun Movie.toTop250MoviesDb(): Top250MoviesDbEntity =
    Top250MoviesDbEntity(
        id = id,
        title = title,
        description = description,
        rating = rating,
        image = image,
        year = year
    )

fun Movies.toDomain(): Movie =
    Movie(
        id = id,
        title = title,
        description = description,
        rating = rating,
        image = image,
        images = (images spitToList OBJECT_SEPARATOR).map { it toImage ITEM_SEPARATOR },
        year = year
    )

internal fun Movie.toMovieDb(): Movies =
    Movies(
        id = id,
        title = title,
        description = description,
        rating = rating,
        image = image,
        images = images.joinToString(OBJECT_SEPARATOR.toString()) { it.toDb(ITEM_SEPARATOR) },
        year = year
    )
