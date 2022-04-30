package ru.marslab.samplemovie.shared.data.database

import android.content.Context
import ru.marslab.samplemovie.shared.DatabaseDriverFactory
import ru.marslab.simplemovie.shared.database.MovieDatabase

internal class AndroidDatabaseFactory(context: Context, databaseName: String) {
    private val databaseDriverFactory = DatabaseDriverFactory(context, databaseName)

    fun get(): MovieDatabase =
        MovieDatabase.invoke(databaseDriverFactory.createDriver())
}
