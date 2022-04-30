package ru.marslab.simplemovie.presentation.top250movies

import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import ru.marslab.simplemovie.core.Action
import ru.marslab.simplemovie.core.BaseViewModel
import ru.marslab.simplemovie.domain.interactor.GetTop250MoviesInteractor
import ru.marslab.simplemovie.presentation.top250movies.model.Top250MoviesState
import javax.inject.Inject

@HiltViewModel
internal class Top250MoviesViewModel @Inject constructor(
    private val getTop250Movies: GetTop250MoviesInteractor
) :
    BaseViewModel<Top250MoviesState>(
        Top250MoviesState()
    ) {

    init {
        launch {
            getTop250Movies()
                .catch { handleError(it) }
                .onStart { reduceState { state.value.copy(isLoading = true) } }
                .collect { movies ->
                    reduceState {
                        state.value.copy(
                            movies = movies.map { it.toShortUi() },
                            isLoading = false
                        )
                    }
                }
        }
    }

    override fun reduceStateByAction(
        currentState: Top250MoviesState,
        action: Action
    ): Top250MoviesState {
        return currentState
    }
}
