package ru.marslab.samplemovie.shared

import com.squareup.sqldelight.db.SqlDriver

internal expect class Platform() {
    val platform: String
}

internal expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
