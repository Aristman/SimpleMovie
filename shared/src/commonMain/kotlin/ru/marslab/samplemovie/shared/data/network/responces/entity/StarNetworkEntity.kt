package ru.marslab.samplemovie.shared.data.network.responces.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarNetworkEntity(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?
)
