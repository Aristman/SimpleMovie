package ru.marslab.samplemovie.shared.data.network.responces.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CastNetworkEntity(
    @SerialName("items")
    val items: List<CastItemNetworkEntity>,
    @SerialName("job")
    val job: String
) {
    @Serializable
    data class CastItemNetworkEntity(
        @SerialName("description")
        val description: String,
        @SerialName("id")
        val id: String,
        @SerialName("name")
        val name: String
    )
}
