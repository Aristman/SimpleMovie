package ru.marslab.simplemovie.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.marslab.samplemovie.shared.data.db.DataStore
import ru.marslab.samplemovie.shared.data.db.PagingDataStore
import ru.marslab.samplemovie.shared.data.db.toDomain
import ru.marslab.samplemovie.shared.data.network.MovieApi
import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.domain.MovieRepository
import javax.inject.Inject

internal class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val dataStore: DataStore,
    private val pagingDataStore: PagingDataStore,
    private val pageSize: Int = 10,
    override val dispatcher: CoroutineDispatcher = Dispatchers.Default
) : MovieRepository {

    override fun getTop250Movies(fromNetwork: Boolean): Flow<PagingData<Movie>> = flow {
        if (dataStore.top250MoviesIsEmpty() || fromNetwork) {
            dataStore.saveTop250Movies(movieApi.getTop250Movies())
        }
        emitAll(
            Pager(PagingConfig(pageSize = pageSize)) {
                pagingDataStore.getTop250MoviesPagingSource()
            }.flow.map { flowData ->
                flowData.map { it.toDomain() }
            }
        )
    }.flowOn(dispatcher)

    override fun getMovieInfo(movieId: String, fromNetwork: Boolean): Flow<Movie> = flow {
        var storeMovie = dataStore.getMovie(movieId)
        if (fromNetwork || storeMovie == null) {
            storeMovie = movieApi.getMovie(movieId)
            dataStore.saveMovie(storeMovie)
        }
        emit(storeMovie)
    }
}
