package ru.marslab.samplemovie.shared

import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

internal expect class Platform() {
    val platform: String
}

internal expect fun httpClient(
    enableLogging: Boolean,
    config: HttpClientConfig<*>.() -> Unit
): HttpClient

internal expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
