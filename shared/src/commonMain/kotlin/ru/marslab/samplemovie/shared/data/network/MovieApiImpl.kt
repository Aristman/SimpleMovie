package ru.marslab.samplemovie.shared.data.network

import io.ktor.client.HttpClient

internal class MovieApiImpl(
    private val baseUrl: String,
    private val htpClient: HttpClient
) : MovieApi
