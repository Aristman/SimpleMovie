package ru.marslab.samplemovie.shared

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import ru.marslab.simplemovie.shared.database.MovieDatabase

internal actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

internal actual class DatabaseDriverFactory(
    private val context: Context,
    private val databaseName: String
) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(schema = MovieDatabase.Schema, context = context, name = databaseName)
}
