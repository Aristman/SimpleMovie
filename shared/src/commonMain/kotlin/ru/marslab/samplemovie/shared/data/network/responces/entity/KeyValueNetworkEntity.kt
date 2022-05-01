package ru.marslab.samplemovie.shared.data.network.responces.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KeyValueNetworkEntity(
    @SerialName("key")
    val key: String?,
    @SerialName("value")
    val value: String?
)
