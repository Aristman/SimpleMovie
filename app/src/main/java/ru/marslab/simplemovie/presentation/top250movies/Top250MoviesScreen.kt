package ru.marslab.simplemovie.presentation.top250movies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.skydoves.landscapist.glide.GlideImage
import ru.marslab.simplemovie.R
import ru.marslab.simplemovie.presentation.items
import ru.marslab.simplemovie.presentation.top250movies.model.MovieShortUi
import ru.marslab.simplemovie.presentation.top250movies.model.Top250MoviesAction
import ru.marslab.simplemovie.presentation.widgets.LoadingStateWidget
import ru.marslab.simplemovie.presentation.widgets.MainAppTopBar
import ru.marslab.simplemovie.presentation.widgets.RatingWoundWidget

class Top250MoviesScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<Top250MoviesViewModel>()
        viewModel.setNavigator(LocalNavigator.currentOrThrow)
        Top250MoviesView(viewModel)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Top250MoviesView(viewModel: Top250MoviesViewModel) {
    val state = viewModel.state.collectAsState()
    val movies = state.value.movies.collectAsLazyPagingItems()
    val lazyListState = rememberLazyListState()
    Scaffold(
        topBar = { MainAppTopBar(R.string.top_250_movies_header) }
    ) {
        LazyVerticalGrid(cells = GridCells.Fixed(2), state = lazyListState) {
            items(pagingItems = movies) { movie ->
                MovieGridItem(movie) {
                    viewModel.sendAction(Top250MoviesAction.ClickOnMovieCard(it))
                }
            }
        }
    }
    if (state.value.isLoading) {
        LoadingStateWidget()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MovieGridItem(
    movie: MovieShortUi?,
    onClick: (movieId: String) -> Unit
) {
    movie?.let {
        Card(
            onClick = { onClick(movie.id) },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column {
                    GlideImage(imageModel = movie.image)
                    Column(
                        modifier = Modifier
                            .height(104.dp)
                            .padding(horizontal = 8.dp)
                            .padding(top = 24.dp, bottom = 8.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = movie.title)
                        Text(
                            text = movie.year,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 8.dp, bottom = 88.dp)
                ) {
                    RatingWoundWidget(movie.rating)
                }
            }
        }
    }
}
