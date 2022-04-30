package ru.marslab.simplemovie.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.marslab.samplemovie.shared.data.db.DataStore
import ru.marslab.samplemovie.shared.data.db.DataStoreProvider
import ru.marslab.samplemovie.shared.data.network.MovieApi
import ru.marslab.samplemovie.shared.data.network.MovieApiProvider
import ru.marslab.simplemovie.BuildConfig
import ru.marslab.simplemovie.data.DataSource
import ru.marslab.simplemovie.data.DataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideMovieApi(): MovieApi =
        MovieApiProvider().get(
            baseUrl = BuildConfig.baseUrl,
            enableLogging = BuildConfig.logging
        )

    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore =
        DataStoreProvider().get(
            context = context,
            databaseName = BuildConfig.databaseName
        )

    @Provides
    fun provideDataSource(movieApi: MovieApi, dataStore: DataStore): DataSource =
        DataSourceImpl(movieApi, dataStore)
}
