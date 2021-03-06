package ru.marslab.samplemovie.shared.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.path
import ru.marslab.samplemovie.shared.data.network.responces.TitleResponse
import ru.marslab.samplemovie.shared.data.network.responces.Top250MoviesResponse
import ru.marslab.samplemovie.shared.data.network.responces.entity.MovieOption
import ru.marslab.samplemovie.shared.domain.entity.Movie

private const val API = "API"
private const val TOP250MOVIES = "Top250Movies"
private const val TITLE = "Title"
private const val LANG = "ru"

internal class MovieApiImpl(
    private val baseUrl: String,
    private val apiKey: String,
    private val httpClient: HttpClient
) : MovieApi {

    override suspend fun getTop250Movies(): List<Movie> =
        httpClient.get {
            url {
                url(baseUrl)
                path(API, TOP250MOVIES, apiKey)
            }
        }.handleBody<Top250MoviesResponse>().convert()

    override suspend fun getMovie(movieId: String): Movie =
        httpClient.get {
            url {
                url(baseUrl)
                path(
                    LANG,
                    API,
                    TITLE,
                    apiKey,
                    movieId,
                    "${MovieOption.Images.name},${MovieOption.Posters.name}"
                )
            }
        }.handleBody<TitleResponse>().convert()
}
