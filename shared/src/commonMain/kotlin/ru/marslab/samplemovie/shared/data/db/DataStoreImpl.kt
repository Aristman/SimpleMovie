package ru.marslab.samplemovie.shared.data.db

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.shared.database.MovieDatabase

internal class DataStoreImpl(database: MovieDatabase) : DataStore {
    private val movieDBQueries = database.movieDBQueries

    override suspend fun top250MoviesIsEmpty(): Boolean =
        movieDBQueries.top250MoviesCount()
            .executeAsOne() == 0L

    override fun saveTop250Movies(movies: List<Movie>): Flow<Unit> = flow {
        emit(
            movieDBQueries.transaction {
                movieDBQueries.clearTop250Movies()
                movies.forEach { movie ->
                    movieDBQueries.saveMovieToTop250(movie.toDb())
                }
            }
        )
    }
}
