package ru.marslab.simplemovie.presentation.top250movies

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class Top250MoviesScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<Top250MoviesViewModel>()
        viewModel.setNavigator(LocalNavigator.currentOrThrow)
        Top250MoviesView(viewModel)
    }
}

@Composable
private fun Top250MoviesView(viewModel: Top250MoviesViewModel) {
}
