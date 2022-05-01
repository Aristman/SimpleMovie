package ru.marslab.samplemovie.shared.data.network.responces.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorNetworkEntity(
    @SerialName("asCharacter")
    val asCharacter: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("name")
    val name: String?
)
