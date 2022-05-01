package ru.marslab.simplemovie.presentation.top250movies

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import ru.marslab.simplemovie.core.BaseViewModel
import ru.marslab.simplemovie.domain.interactor.GetTop250MoviesInteractor
import ru.marslab.simplemovie.presentation.moviedetail.MovieDetailScreen
import ru.marslab.simplemovie.presentation.top250movies.model.Top250MoviesAction
import ru.marslab.simplemovie.presentation.top250movies.model.Top250MoviesState
import ru.marslab.simplemovie.presentation.top250movies.model.toShortUi
import javax.inject.Inject

@HiltViewModel
internal class Top250MoviesViewModel @Inject constructor(
    private val getTop250Movies: GetTop250MoviesInteractor
) :
    BaseViewModel<Top250MoviesState, Nothing, Top250MoviesAction>(
        Top250MoviesState()
    ) {

    init {
        launch {
            getTop250Movies()
                .catch { handleError(it) }
                .onStart { reduceState { state.value.copy(isLoading = true) } }
                .map { pagingData ->
                    pagingData.map { it.toShortUi() }
                }
                .cachedIn(viewModelScope)
                .collectLatest {
                    reduceState {
                        state.value.copy(
                            movies = flowOf(it),
                            isLoading = false
                        )
                    }
                }
        }
    }

    override fun reduceStateByAction(
        currentState: Top250MoviesState,
        action: Top250MoviesAction
    ): Top250MoviesState =
        when (action) {
            is Top250MoviesAction.ClickOnMovieCard -> {
                navigator.push(MovieDetailScreen(action.movieId))
                currentState
            }
        }
}
