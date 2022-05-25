package ru.marslab.samplemovie.shared.data.db

import androidx.paging.PagingSource
import com.squareup.sqldelight.android.paging3.QueryPagingSource
import ru.marslab.simplemovie.shared.database.MovieDatabase
import ru.marslab.simplemovie.shared.database.Top250MoviesDbEntity

class PagingDataStoreImpl(dataBase: MovieDatabase) : PagingDataStore {
    private val movieDBQueries = dataBase.movieDBQueries

    override fun getTop250MoviesPagingSource(): PagingSource<Long, Top250MoviesDbEntity> =
        QueryPagingSource(
            countQuery = movieDBQueries.top250MoviesCount(),
            transacter = movieDBQueries,
            queryProvider = movieDBQueries::getTop250Movies
        )
}
