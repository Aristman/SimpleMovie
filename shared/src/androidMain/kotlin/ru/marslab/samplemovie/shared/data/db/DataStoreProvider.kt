package ru.marslab.samplemovie.shared.data.db

import android.content.Context

class DataStoreProvider {
    fun get(context: Context, databaseName: String): DataStore =
        DataStoreImpl(database = AndroidDatabaseFactory(context, databaseName).get())
}
