package ru.marslab.simplemovie.presentation.moviedetail

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import ru.marslab.simplemovie.core.BaseViewModel
import ru.marslab.simplemovie.domain.interactor.GetMovieInfoInteractor
import ru.marslab.simplemovie.presentation.moviedetail.model.MovieDetailAction
import ru.marslab.simplemovie.presentation.moviedetail.model.MovieDetailState
import ru.marslab.simplemovie.presentation.moviedetail.model.toFullUi
import javax.inject.Inject

@HiltViewModel
internal class MovieDetailViewModel @Inject constructor(
    private val getMovieInfo: GetMovieInfoInteractor
) : BaseViewModel<MovieDetailState, Nothing, MovieDetailAction>(MovieDetailState()) {
    override fun reduceStateByAction(
        currentState: MovieDetailState,
        action: MovieDetailAction
    ): MovieDetailState =
        when (action) {
            is MovieDetailAction.LoadMovieInfo -> {
                loadMovieInfo(action.movieId, action.fromNetwork)
                currentState
            }
        }

    private fun loadMovieInfo(movieId: String, fromNetwork: Boolean) {
        launch {
            getMovieInfo(movieId, fromNetwork)
                .catch {
                    handleError(it)
                    reduceState { state.value.copy(isLoading = false) }
                }
                .onStart { reduceState { state.value.copy(isLoading = true) } }
                .collect {
                    reduceState {
                        state.value.copy(
                            movie = it.toFullUi(),
                            isLoading = false
                        )
                    }
                }
        }
    }
}
