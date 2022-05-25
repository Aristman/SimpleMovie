package ru.marslab.samplemovie.shared.data.db

import android.content.Context

class DataStoreProvider(context: Context, databaseName: String) {
    private val database = AndroidDatabaseFactory(context, databaseName).get()

    fun get(): DataStore =
        DataStoreImpl(database = database)

    fun getPaging(): PagingDataStore =
        PagingDataStoreImpl(dataBase = database)
}
