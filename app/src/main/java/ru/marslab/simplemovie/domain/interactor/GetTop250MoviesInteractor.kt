package ru.marslab.simplemovie.domain.interactor

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.domain.MovieRepository
import javax.inject.Inject

class GetTop250MoviesInteractor @Inject constructor(
    private val movieRepository: MovieRepository
) {

    operator fun invoke(fromNetwork: Boolean = false): Flow<PagingData<Movie>> =
        movieRepository.getTop250Movies(fromNetwork)
}
