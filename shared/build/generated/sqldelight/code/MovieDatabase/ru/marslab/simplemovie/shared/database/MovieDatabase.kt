package ru.marslab.simplemovie.shared.database

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import ru.marslab.simplemovie.shared.database.shared.newInstance
import ru.marslab.simplemovie.shared.database.shared.schema

public interface MovieDatabase : Transacter {
  public val movieDBQueries: MovieDBQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = MovieDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): MovieDatabase =
        MovieDatabase::class.newInstance(driver)
  }
}
