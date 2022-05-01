package ru.marslab.simplemovie.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.marslab.samplemovie.shared.domain.entity.Movie
import ru.marslab.simplemovie.domain.MovieRepository
import javax.inject.Inject

class GetMovieInfoInteractor @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(movieId: String, fromNetwork: Boolean = false): Flow<Movie> =
        repository.getMovieInfo(movieId, fromNetwork)
}
