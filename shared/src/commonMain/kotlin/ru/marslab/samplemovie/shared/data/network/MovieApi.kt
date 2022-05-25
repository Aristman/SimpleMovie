package ru.marslab.samplemovie.shared.data.network

import ru.marslab.samplemovie.shared.domain.entity.Movie

interface MovieApi {
    suspend fun getTop250Movies(): List<Movie>
    suspend fun getMovie(movieId: String): Movie
}
