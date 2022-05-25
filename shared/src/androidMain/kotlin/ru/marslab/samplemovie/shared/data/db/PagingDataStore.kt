package ru.marslab.samplemovie.shared.data.db

import androidx.paging.PagingSource
import ru.marslab.simplemovie.shared.database.Top250MoviesDbEntity

interface PagingDataStore {
    fun getTop250MoviesPagingSource(): PagingSource<Long, Top250MoviesDbEntity>
}
