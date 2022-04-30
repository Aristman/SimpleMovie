package ru.marslab.simplemovie.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.core.BaseRepository

interface MovieRepository : BaseRepository {
    fun getTop250Movies(fromNetwork: Boolean): Flow<PagingData<Movie>>
}
