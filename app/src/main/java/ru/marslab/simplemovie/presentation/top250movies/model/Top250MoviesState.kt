package ru.marslab.simplemovie.presentation.top250movies.model

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal data class Top250MoviesState(
    val movies: Flow<PagingData<MovieShortUi>> = flowOf(PagingData.empty()),
    val isLoading: Boolean = false
)
