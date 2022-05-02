package ru.marslab.samplemovie.shared.data.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.marslab.samplemovie.shared.httpClient

internal class HttpClientFactory(enableLogging: Boolean) {

    private val httpClient = httpClient(enableLogging) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    coerceInputValues = true
                }
            )
        }
    }

    fun get(): HttpClient =
        httpClient
}
