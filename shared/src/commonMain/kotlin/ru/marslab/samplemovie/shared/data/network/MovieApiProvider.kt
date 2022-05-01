package ru.marslab.samplemovie.shared.data.network

class MovieApiProvider {

    fun get(baseUrl: String, apiKey: String, enableLogging: Boolean): MovieApi =
        MovieApiImpl(
            baseUrl = baseUrl,
            apiKey = apiKey,
            httpClient = HttpClientFactory(enableLogging).get()
        )
}
