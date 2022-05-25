package ru.marslab.simplemovie.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.marslab.samplemovie.shared.data.db.DataStore
import ru.marslab.samplemovie.shared.data.db.DataStoreProvider
import ru.marslab.samplemovie.shared.data.db.PagingDataStore
import ru.marslab.samplemovie.shared.data.network.MovieApi
import ru.marslab.samplemovie.shared.data.network.MovieApiProvider
import ru.marslab.simplemovie.BuildConfig
import ru.marslab.simplemovie.data.MovieRepositoryImpl
import ru.marslab.simplemovie.domain.MovieRepository
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Named("databaseName")
    fun provideDatabaseName(): String = BuildConfig.databaseName

    @Provides
    fun provideMovieApi(): MovieApi =
        MovieApiProvider().get(
            baseUrl = BuildConfig.baseUrl,
            apiKey = BuildConfig.imdbMoviesApiKey,
            enableLogging = BuildConfig.logging
        )

    @Provides
    fun provideDataStore(
        @ApplicationContext context: Context,
        @Named("databaseName") databaseName: String
    ): DataStore =
        DataStoreProvider(
            context = context,
            databaseName = databaseName
        ).get()

    @Provides
    fun providePagingDataStore(
        @ApplicationContext context: Context,
        @Named("databaseName") databaseName: String
    ): PagingDataStore =
        DataStoreProvider(
            context = context,
            databaseName = databaseName
        ).getPaging()

    @Provides
    fun provideDataSource(
        movieApi: MovieApi,
        dataStore: DataStore,
        pagingDataStore: PagingDataStore
    ): MovieRepository =
        MovieRepositoryImpl(movieApi, dataStore, pagingDataStore)
}
