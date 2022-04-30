package ru.marslab.samplemovie.shared.data.network.responces

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.marslab.samplemovie.shared.data.exceptions.ServerException
import ru.marslab.samplemovie.shared.data.network.responces.base.Dto
import ru.marslab.samplemovie.shared.data.network.responces.entity.MovieNetworkEntity
import ru.marslab.samplemovie.shared.domain.entity.Movie

@Serializable
data class Top250MoviesResponse(
    @SerialName("errorMessage")
    val errorMessage: String,
    @SerialName("items")
    val items: List<MovieNetworkEntity>
) : Dto<List<Movie>> {
    override fun convert(): List<Movie> {
        if (errorMessage.isNotBlank()) throw ServerException(errorMessage)
        return items.map {
            Movie(
                id = it.id,
                title = it.title,
                description = it.fullTitle,
                rating = kotlin.runCatching { it.rank.toFloat() }.getOrDefault(0f),
                image = it.image,
                year = it.year
            )
        }
    }
}
