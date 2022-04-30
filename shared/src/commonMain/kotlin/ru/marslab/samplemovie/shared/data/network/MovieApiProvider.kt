package ru.marslab.samplemovie.shared.data.network

import io.ktor.client.HttpClient

class MovieApiProvider {

    fun get(baseUrl: String, httpClient: HttpClient): MovieApi =
        MovieApiImpl(baseUrl, httpClient)
}
