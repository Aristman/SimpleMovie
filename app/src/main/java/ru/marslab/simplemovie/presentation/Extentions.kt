package ru.marslab.simplemovie.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems

@OptIn(ExperimentalFoundationApi::class)
fun <T : Any> LazyGridScope.items(
    pagingItems: LazyPagingItems<T>,
    content: @Composable LazyItemScope.(item: T?) -> Unit
) {
    items(count = pagingItems.itemCount) {
        content(pagingItems[it])
    }
}
