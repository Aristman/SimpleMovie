package ru.marslab.simplemovie.presentation.top250movies.model

import androidx.paging.PagingData

internal data class Top250MoviesState(
    val movies: PagingData<MovieShortUi> = PagingData.empty(),
    val isLoading: Boolean = false
)
