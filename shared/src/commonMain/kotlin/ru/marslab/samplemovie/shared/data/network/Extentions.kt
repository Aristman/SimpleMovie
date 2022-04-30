package ru.marslab.samplemovie.shared.data.network

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import ru.marslab.samplemovie.shared.data.exceptions.ServerException

@Throws(Exception::class)
internal fun HttpResponse.completable() {
    if (!status.isSuccess()) {
        throw ServerException()
    }
}

@Throws(Exception::class)
internal suspend inline fun <reified D> HttpResponse.handleBody(): D =
    if (status.isSuccess()) {
        body()
    } else {
        errorCodeHandler(status.value)
    }

@Throws(Exception::class)
private fun errorCodeHandler(code: Int): Nothing {
    throw when (code) {
        HttpStatusCode.NotFound.value -> ServerException(HttpStatusCode.NotFound.description)
        else -> ServerException()
    }
}
