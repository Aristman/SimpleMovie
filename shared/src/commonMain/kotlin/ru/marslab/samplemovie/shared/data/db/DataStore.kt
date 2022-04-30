package ru.marslab.samplemovie.shared.data.db

import kotlinx.coroutines.flow.Flow
import ru.marslab.samplemovie.shared.domain.entity.Movie

interface DataStore {
    suspend fun top250MoviesIsEmpty(): Boolean
    fun saveTop250Movies(movies: List<Movie>): Flow<Unit>
}
