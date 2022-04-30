package ru.marslab.samplemovie.shared.data.network

class MovieApiProvider {

    fun get(baseUrl: String, enableLogging: Boolean): MovieApi =
        MovieApiImpl(
            baseUrl = baseUrl,
            htpClient = HttpClientFactory(enableLogging).get()
        )
}
