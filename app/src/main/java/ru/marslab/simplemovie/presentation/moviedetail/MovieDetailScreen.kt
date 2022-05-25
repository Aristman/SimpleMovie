package ru.marslab.simplemovie.presentation.moviedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.skydoves.landscapist.glide.GlideImage
import ru.marslab.simplemovie.R
import ru.marslab.simplemovie.presentation.moviedetail.model.MovieDetailAction
import ru.marslab.simplemovie.presentation.moviedetail.model.MovieFullUi
import ru.marslab.simplemovie.presentation.widgets.LoadingStateWidget
import ru.marslab.simplemovie.presentation.widgets.MainAppTopBar
import ru.marslab.simplemovie.presentation.widgets.MediumSpacer
import ru.marslab.simplemovie.presentation.widgets.RatingRoundWidget
import ru.marslab.simplemovie.presentation.widgets.SmallSpacer

class MovieDetailScreen(private val movieId: String) : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<MovieDetailViewModel>()
        viewModel.setNavigator(LocalNavigator.currentOrThrow)
        viewModel.sendAction(MovieDetailAction.LoadMovieInfo(movieId))
        MovieDetailView(viewModel)
    }
}

@Composable
private fun MovieDetailView(viewModel: MovieDetailViewModel) {
    val state = viewModel.state.collectAsState()
    val movie = state.value.movie
    Scaffold(
        topBar = {
            MainAppTopBar(
                text = state.value.movie.title,
                style = MaterialTheme.typography.h6,
                backIcon = true,
                onBackClick = viewModel::popUp,
                refreshIcon = true,
                onRefreshClick = {
                    viewModel.sendAction(
                        MovieDetailAction.LoadMovieInfo(
                            state.value.movie.id,
                            true
                        )
                    )
                }
            )
        }
    ) {
        Column {
            HeaderMovieCard(movie)
            MediumSpacer()
            BodyMovieCard(movie)
        }
    }
    if (state.value.isLoading) {
        LoadingStateWidget()
    }
}

@Composable
private fun BodyMovieCard(movie: MovieFullUi) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = stringResource(id = R.string.movie_description_title),
            style = MaterialTheme.typography.h5
        )
        Text(text = movie.description)
    }
}

@Composable
private fun HeaderMovieCard(movie: MovieFullUi) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(248.dp)
    ) {
        GlideImage(
            imageModel = movie.poster,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxSize()

        )
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxSize()
                .alpha(0.5f)
                .background(Color.Black)

        )
        Text(
            text = movie.title,
            style = MaterialTheme.typography.h5,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopStart)
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 16.dp)
        ) {
            GlideImage(
                imageModel = movie.image,
                modifier = Modifier
                    .size(width = 88.dp, height = 144.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(Modifier.padding(start = 16.dp)) {
                Text(
                    text = stringResource(id = R.string.released, movie.release),
                    color = Color.White
                )
                SmallSpacer()
                Text(
                    text = movie.runtime,
                    color = Color.White
                )
                SmallSpacer()
                Text(
                    text = movie.genres,
                    color = Color.White
                )
                SmallSpacer()
                RatingRoundWidget(rating = movie.rating)
            }
        }
    }
}
