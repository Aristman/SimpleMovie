package ru.marslab.samplemovie.shared.data.network

import io.ktor.client.HttpClient

class MovieApiImpl(
    private val baseUrl: String,
    private val htpClient: HttpClient
) : MovieApi
