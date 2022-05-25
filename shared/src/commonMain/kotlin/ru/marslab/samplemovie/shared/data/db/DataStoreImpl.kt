package ru.marslab.samplemovie.shared.data.db

import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.shared.database.MovieDatabase

internal class DataStoreImpl(database: MovieDatabase) : DataStore {
    private val movieDBQueries = database.movieDBQueries

    override suspend fun top250MoviesIsEmpty(): Boolean =
        movieDBQueries.top250MoviesCount()
            .executeAsOne() == 0L

    override suspend fun saveTop250Movies(movies: List<Movie>) {
        movieDBQueries.transaction {
            movieDBQueries.clearTop250Movies()
            movies.forEach { movie ->
                movieDBQueries.saveMovieToTop250(movie.toTop250MoviesDb())
            }
        }
    }

    override suspend fun getMovie(movieId: String): Movie? =
        movieDBQueries.getMovie(movieId)
            .executeAsOneOrNull()
            ?.toDomain()

    override suspend fun saveMovie(movie: Movie) {
        movieDBQueries.updateMovie(movie.toMovieDb())
    }
}
