package ru.marslab.samplemovie.shared

import android.content.Context
import android.util.Log
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import ru.marslab.simplemovie.shared.database.MovieDatabase
import java.util.concurrent.TimeUnit

internal actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

internal actual fun httpClient(
    enableLogging: Boolean,
    config: HttpClientConfig<*>.() -> Unit
) = HttpClient(OkHttp) {
    config(this)
    if (enableLogging) {
        install(Logging) {
            logger = AppLogger
            level = LogLevel.ALL
        }
    }
    engine {
        config {
            retryOnConnectionFailure(true)
            connectTimeout(7, TimeUnit.SECONDS)
        }
    }
}

internal actual class DatabaseDriverFactory(
    private val context: Context,
    private val databaseName: String
) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(schema = MovieDatabase.Schema, context = context, name = databaseName)
}

private object AppLogger : Logger {
    private const val LOGGER_TAG = "HttpLogger"

    override fun log(message: String) {
        Log.d(LOGGER_TAG, message)
    }
}
