package ru.marslab.samplemovie.shared.data.network.responces

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.marslab.samplemovie.shared.data.network.responces.entity.ActorNetworkEntity
import ru.marslab.samplemovie.shared.data.network.responces.entity.CastNetworkEntity

@Serializable
data class FullCastResponse(
    @SerialName("imDbId")
    val imDbId: String,
    @SerialName("title")
    val title: String,
    @SerialName("fullTitle")
    val fullTitle: String,
    @SerialName("type")
    val type: String,
    @SerialName("year")
    val year: String,
    @SerialName("directors")
    val directors: CastNetworkEntity,
    @SerialName("writers")
    val writers: CastNetworkEntity,
    @SerialName("actors")
    val actors: List<ActorNetworkEntity>?,
    @SerialName("others")
    val others: CastNetworkEntity?,
    @SerialName("errorMessage")
    val errorMessage: String?
)
