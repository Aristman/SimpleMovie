package ru.marslab.simplemovie.core

import kotlinx.coroutines.CoroutineDispatcher

interface BaseRepository {
    val dispatcher: CoroutineDispatcher
}
