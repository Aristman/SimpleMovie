package ru.marslab.simplemovie.data

import ru.marslab.samplemovie.shared.data.db.DataStore
import ru.marslab.samplemovie.shared.data.network.MovieApi
import javax.inject.Inject

internal class DataSourceImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val dataStore: DataStore
) : DataSource
