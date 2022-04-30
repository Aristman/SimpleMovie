package ru.marslab.samplemovie.shared.data.database

import android.content.Context
import ru.marslab.samplemovie.shared.data.DataStore
import ru.marslab.samplemovie.shared.data.DataStoreImpl

class DataStoreProvider {
    fun get(context: Context, databaseName: String): DataStore =
        DataStoreImpl(database = AndroidDatabaseFactory(context, databaseName).get())
}
