package ru.marslab.samplemovie.shared.data.db

import ru.marslab.samplemovie.shared.domain.entity.Movie

interface DataStore {
    suspend fun top250MoviesIsEmpty(): Boolean
    suspend fun saveTop250Movies(movies: List<Movie>)
    suspend fun getMovie(movieId: String): Movie?
    suspend fun saveMovie(movie: Movie)
}
